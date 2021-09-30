import 'dart:async';
import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_custom_dialog/flutter_custom_dialog.dart';
import 'package:intl/intl.dart';
import 'package:time_recorder/bloc/employee_bloc.dart';
import 'package:time_recorder/data_layer/BreakLunchInOut.dart';
import 'package:time_recorder/data_layer/ClockInOut.dart';
import 'package:time_recorder/data_layer/ClockStatus.dart';
import 'package:time_recorder/data_layer/Shift.dart';
import 'package:time_recorder/data_layer/Task.dart';
import 'package:time_recorder/data_layer/TaskLog.dart';
import 'package:time_recorder/data_layer/TimeStatus.dart';
import 'package:time_recorder/theme/colors.dart';
import 'package:time_recorder/utils/global.dart';
import 'package:time_recorder/utils/prefs.dart';

class EmployeeHome extends StatefulWidget {
  const EmployeeHome({Key? key}) : super(key: key);

  @override
  _EmployeeHomeState createState() => _EmployeeHomeState();
}

class _EmployeeHomeState extends State<EmployeeHome> {
  late EmployeeBloc _blocEmployee;

  List<Task> listOfDirectTask = [];
  List<Task> listOfIndirectTask = [];

  var isClockIn = false;
  var isLunchIn = false;
  var isBreakIn = false;
  var clockInTime = 1;

  var totalClockTime = 1.0;
  var totalBreakTime = 1.0;
  var totalLunchTime = 1.0;

  late String currentDateAndTime = "";
  late DateFormat dateFormat;

  @override
  void initState() {
    _blocEmployee = EmployeeBloc();

    getInitialWorkDone();
    getDirectAndIndirectTasks();

    _blocEmployee.getTaskLogs(Prefs.getToken()!);
    _blocEmployee.getShiftTime(Prefs.getToken()!);

    dateFormat = DateFormat("yyyy-MMMM-dd hh:mm aaa");
    currentDateAndTime = dateFormat.format(DateTime.now());

    Timer.periodic(
        Duration(hours: 0, minutes: 1, seconds: 0),
        (Timer t) => setState(() {
              currentDateAndTime = dateFormat.format(DateTime.now());
            }));
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        width: double.infinity,
        height: double.infinity,
        decoration: BoxDecoration(
            image: DecorationImage(
                image: AssetImage("assets/emp_home_background_img.png"),
                fit: BoxFit.cover)),
        child: SingleChildScrollView(
          child: Column(
            children: [
              Material(
                elevation: 3,
                child: Container(
                  color: CustomColors.blue_color,
                  alignment: Alignment.center,
                  width: double.infinity,
                  height: 50,
                  child: Text(
                    "HOME",
                    style: TextStyle(
                      color: Colors.white,
                      fontWeight: FontWeight.bold,
                      fontSize: 25,
                    ),
                  ),
                ),
              ),
              SizedBox(
                height: 30,
              ),
              Text(
                currentDateAndTime,
                style: TextStyle(
                    color: CustomColors.white_color,
                    fontWeight: FontWeight.bold,
                    fontSize: 20),
              ),
              SizedBox(
                height: 10,
              ),
              Text(
                "00:00:00",
                style: TextStyle(
                    color: CustomColors.white_color,
                    fontWeight: FontWeight.bold,
                    fontSize: 15),
              ),
              SizedBox(
                height: 20,
              ),
              StreamBuilder<ClockStatus>(
                stream: _blocEmployee.clockStatus,
                  builder: (context, snapshot) {
                    var clockStatus = snapshot.data;
                    if (clockStatus != null) {
                      isClockIn = clockStatus.isClockedIn;
                      isLunchIn = clockStatus.isLunch;
                      isBreakIn = clockStatus.isBreak;
                      clockInTime = clockStatus.startTime;
                    }
                  return Padding(
                    padding: const EdgeInsets.all(10.0),
                    child: Container(
                      width: double.infinity,
                      child: Text(
                        "Task Logs",
                        style: TextStyle(color: Colors.white),
                      ),
                    ),
                  );
                }
              ),
              Padding(
                padding: const EdgeInsets.all(10.0),
                child: Container(
                    height: 200, child: _buildTaskLogsList(_blocEmployee)),
              ),
              SizedBox(
                height: 30,
              ),
              Padding(
                padding: const EdgeInsets.all(10.0),
                child:  StreamBuilder<TimeStatus>(
                          stream: _blocEmployee.timeStatus,
                          builder: (context, snapshot) {

                            print("dsfdfddd");

                            var timeStatus = snapshot.data;

                            if (timeStatus != null) {

                              print(timeStatus);

                              totalClockTime = timeStatus.totalClockTime == 0
                                  ? 1.0
                                  : timeStatus.totalClockTime;
                              totalBreakTime = timeStatus.totalBreakTime == 0
                                  ? 1
                                  : timeStatus.totalBreakTime;
                              totalLunchTime = timeStatus.totalLunchTime == 0
                                  ? 1
                                  : timeStatus.totalLunchTime;

                            }
                            return Container(
                              width: double.infinity,
                              child: Text(
                                "Shift Timing",
                                style: TextStyle(color: Colors.white),
                              ),
                            );
                    }),
              ),
              Padding(
                padding: const EdgeInsets.all(10.0),
                child: StreamBuilder<Shift>(
                    stream: _blocEmployee.shift,
                    builder: (context, snapshot) {
                      var shift = snapshot.data;
                      if (shift != null) {
                        return _buttonsList(shift);
                      } else {
                        return Container();
                      }
                    }),
              ),
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildTaskLogsList(EmployeeBloc blocEmployee) {
    return StreamBuilder<List<TaskLog>>(
        stream: blocEmployee.taskLogs,
        builder: (context, snapshot) {
          var data = snapshot.data;

          if (data == null) {
            return Center(child: Text('No Task Logs'));
          }

          if (data.isEmpty) {
            return Center(child: Text('No Task Logs'));
          }else{
            return _list(data);
          }
        });
  }

  Widget _list(List<TaskLog> taskLogs) {
    return Container(
      child: ListView.builder(
          itemCount: taskLogs.length,
          itemBuilder: (context, index) {
            final taskLog = taskLogs[index];

            return taskLogWidget(taskLog);
          }),
    );
  }

  Widget taskLogWidget(TaskLog taskLog) {
    return GestureDetector(
      child: Container(
        height: 40,
        margin: EdgeInsets.fromLTRB(0, 0, 0, 5),
        alignment: Alignment.center,
        decoration: BoxDecoration(
          color: Colors.white,
          borderRadius: BorderRadius.circular(5.0),
        ),
        child: Padding(
          padding: const EdgeInsets.all(10.0),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Text(taskLog.title),
              Text(secondsIntoTime(taskLog.time.toInt()))
            ],
          ),
        ),
      ),
    );
  }

  Widget _buttonsList(Shift shift) {
    return Container(
      child: Column(
        children: [
          GestureDetector(
            onTap: () => {
              if (isClockIn)
                {Global.showToast("You are already Clocked-In")}
              else
                {getClockInOut(1)}
            },
            child: StreamBuilder<ClockInOut>(
                stream: _blocEmployee.clockInOut,
                builder: (context, snapshot) {
                  var clockInOut = snapshot.data;
                  if (clockInOut != null) {
                    isClockIn = clockInOut.isClockedIn;
                    clockInTime = clockInOut.clockInTime;
                    WidgetsBinding.instance!.addPostFrameCallback((_) {

                    });
                  }
                  return Container(
                    height: 40,
                    margin: EdgeInsets.fromLTRB(0, 0, 0, 5),
                    alignment: Alignment.center,
                    decoration: BoxDecoration(
                      color: isClockIn == false && isBreakIn == true || isLunchIn == true
                          ? CustomColors.white_color
                          : CustomColors.yellow_color,
                      borderRadius: BorderRadius.circular(5.0),
                    ),
                    child: Padding(
                      padding: const EdgeInsets.all(10.0),
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: [
                          Text("Clock-In"),
                          Text(shift.clockInTime.toString()),
                          Text(clockInTime == 1
                              ? shift.clockInTime.toString()
                              : getTimeFromTimeStamp(
                                  (clockInTime * 1000).toInt())),
                        ],
                      ),
                    ),
                  );
                }),
          ),
          GestureDetector(
            onTap: () {
              if (isClockIn) {
                if (isBreakIn) {
                  // first check that if any task is active then, first close that active task then, get user break out.
                  var activeTaskId = -1;

                  listOfDirectTask.forEach((directTask) {
                    if (directTask.isActive) {
                      activeTaskId = directTask.taskId;
                    }
                  });

                  listOfIndirectTask.forEach((indirectTask) {
                    if (indirectTask.isActive) {
                      activeTaskId = indirectTask.taskId;
                    }
                  });
                  if (activeTaskId == -1) {
                    getBreakLunchInOut(1, 2);
                  } else {
                    showDialog(1, 2);
                  }
                } else {
                  if (!isLunchIn) {
                    getBreakLunchInOut(1, 1); // first parameter here 1 for break and 2 for lunch, and second argument here 1 for break in and 2 for break out
                  } else {
                    Global.showToast(
                        "You are already on lunch, get first yourself Lunch-Out");
                  }
                }
              } else {
                Global.showToast("You are not Clocked-In");
              }
            },
            child: StreamBuilder<BreakLunchInOut>(
                stream: _blocEmployee.breakLunchInOut,
                builder: (context, snapshot) {
                  var breakLunchInOut = snapshot.data;
                  if (breakLunchInOut != null) {
                    isLunchIn = breakLunchInOut.isLunchIn;
                    isBreakIn = breakLunchInOut.isBreakIn;
                    totalLunchTime = breakLunchInOut.totalLunchTime.toDouble();
                    totalBreakTime = breakLunchInOut.totalBreakTime.toDouble();

                    WidgetsBinding.instance!.addPostFrameCallback((_) {

                    });
                  }
                  return Container(
                    height: 40,
                    margin: EdgeInsets.fromLTRB(0, 0, 0, 5),
                    alignment: Alignment.center,
                    decoration: BoxDecoration(
                      color: isBreakIn == false
                          ? CustomColors.white_color
                          : CustomColors.yellow_color,
                      borderRadius: BorderRadius.circular(5.0),
                    ),
                    child: Padding(
                      padding: const EdgeInsets.all(10.0),
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: [
                          Text("Break"),
                          Text(shift.teaTime.toString() + " (15min)"),
                          Text(totalBreakTime == 1
                              ? "00:00:00"
                              : secondsIntoTime(totalBreakTime.toInt())),
                        ],
                      ),
                    ),
                  );
                }),
          ),
          GestureDetector(
            onTap: () {
              if (isClockIn) {
                if (isLunchIn) {
                  // first check that if any task is active then, first close that active task then, get user lunch out.
                  var activeTaskId = -1;

                  listOfDirectTask.forEach((directTask) {
                    if (directTask.isActive) {
                      activeTaskId = directTask.taskId;
                    }
                  });

                  listOfIndirectTask.forEach((indirectTask) {
                    if (indirectTask.isActive) {
                      activeTaskId = indirectTask.taskId;
                    }
                  });
                  if (activeTaskId == -1) {
                    getBreakLunchInOut(2, 2);
                  } else {
                    showDialog(2, 2);
                  }
                } else {
                  if (!isBreakIn) {
                    getBreakLunchInOut(1, 2);
                  } else {
                    // show toast that first get break out then go on lunch
                    Global.showToast(
                        "You are already on Break, first get yourself Break-Out");
                  }
                }
              } else {
                Global.showToast("You are not Clocked-In");
              }
            },
            child: StreamBuilder<List<Task>>(
                stream: _blocEmployee.indirectTask,
                builder: (context, snapshot) {
                  final results = snapshot.data;
                  if (results != null) {
                    if (results.isNotEmpty) {
                      if (listOfIndirectTask.isEmpty) {
                        listOfIndirectTask = results;
                      } else {
                        listOfIndirectTask = [];
                        listOfIndirectTask = results;
                      }
                    }

                  }

                  return Container(
                    height: 40,
                    margin: EdgeInsets.fromLTRB(0, 0, 0, 5),
                    alignment: Alignment.center,
                    decoration: BoxDecoration(
                      color: isLunchIn == false
                          ? CustomColors.white_color
                          : CustomColors.yellow_color,
                      borderRadius: BorderRadius.circular(5.0),
                    ),
                    child: Padding(
                      padding: const EdgeInsets.all(10.0),
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: [
                          Text("Lunch"),
                          Text(shift.lunchTime.toString() + " (30min)"),
                          Text(totalLunchTime == 1
                              ? "00:00:00"
                              : secondsIntoTime(totalLunchTime.toInt())),
                        ],
                      ),
                    ),
                  );
                }),
          ),
          GestureDetector(
            onTap: () => {
              if (isClockIn)
                {getClockInOut(2)}
              else
                {Global.showToast("You are already Clocked-Out")}
            },
            child: StreamBuilder<List<Task>>(
                stream: _blocEmployee.directTask,
                builder: (context, snapshot) {
                  final results = snapshot.data;

                  if (results != null) {
                    if (results.isNotEmpty) {
                      if (listOfDirectTask.isEmpty) {
                        listOfDirectTask = results;
                      } else {
                        listOfDirectTask = [];
                        listOfDirectTask = results;
                      }
                    }
                  }

                  return Container(
                    height: 40,
                    margin: EdgeInsets.fromLTRB(0, 0, 0, 5),
                    alignment: Alignment.center,
                    decoration: BoxDecoration(
                      color: isClockIn == false
                          ? CustomColors.yellow_color
                          : CustomColors.white_color,
                      borderRadius: BorderRadius.circular(5.0),
                    ),
                    child: Padding(
                      padding: const EdgeInsets.all(10.0),
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: [
                          Text("Clock-Out"),
                          Text(shift.clockOutTime.toString()),
                          Text(shift.clockOutTime.toString()),
                        ],
                      ),
                    ),
                  );
                }),
          ),
        ],
      ),
    );
  }

  String secondsIntoTime(int value) {
    int h, m, s;

    h = value ~/ 3600;

    m = ((value - h * 3600)) ~/ 60;

    s = value - (h * 3600) - (m * 60);

    String result = "$h:$m:$s";

    return result;
  }

  getTimeFromTimeStamp(int clockInTime) {
    var dt = DateTime.fromMillisecondsSinceEpoch(clockInTime);
    return DateFormat('hh:mm a').format(dt);
  }

  Future<void> getInitialWorkDone() async {
    await _blocEmployee.getClockTimeStatus(Prefs.getToken()!);

    var jsonRequestBody = jsonEncode(<String, dynamic>{
      "currentTime": (DateTime.now().millisecondsSinceEpoch / 1000)
    });
    await _blocEmployee.getTotalTime(Prefs.getToken()!, jsonRequestBody);
  }

  getClockInOut(int type) async {
    if (type == 1) {
      var jsonRequestBody = jsonEncode(<String, dynamic>{
        "type": type,
        "clockInTime": (DateTime.now().millisecondsSinceEpoch / 1000),
        "clockOutTime": ""
      });
      await _blocEmployee.getClockInOut(jsonRequestBody, Prefs.getToken()!);
    } else {
      var jsonRequestBody = jsonEncode(<String, dynamic>{
        "type": type,
        "clockInTime": "",
        "clockOutTime": (DateTime.now().millisecondsSinceEpoch / 1000)
      });
      await _blocEmployee.getClockInOut(jsonRequestBody, Prefs.getToken()!);
    }
  }

  getBreakLunchInOut(int type, int status) {
    if (status == 1) {
      if (type == 1) {
        var jsonRequestBody = jsonEncode(<String, dynamic>{
          "type": type,
          "breakInTime": (DateTime.now().millisecondsSinceEpoch / 1000),
          "breakOutTime": "",
          "status": status
        });
        _blocEmployee.getBreakLunchInOut(jsonRequestBody, Prefs.getToken()!);
      } else if (type == 2) {
        var jsonRequestBody = jsonEncode(<String, dynamic>{
          "type": type,
          "breakInTime": "",
          "breakOutTime": (DateTime.now().millisecondsSinceEpoch / 1000),
          "status": status
        });
        _blocEmployee.getBreakLunchInOut(jsonRequestBody, Prefs.getToken()!);
      }
    } else if (status == 2) {
      if (type == 1) {
        var jsonRequestBody = jsonEncode(<String, dynamic>{
          "type": type,
          "breakInTime": (DateTime.now().millisecondsSinceEpoch / 1000),
          "breakOutTime": "",
          "status": status
        });
        _blocEmployee.getBreakLunchInOut(jsonRequestBody, Prefs.getToken()!);
      } else if (type == 2) {
        var jsonRequestBody = jsonEncode(<String, dynamic>{
          "type": type,
          "breakInTime": "",
          "breakOutTime": (DateTime.now().millisecondsSinceEpoch / 1000),
          "status": status
        });
        _blocEmployee.getBreakLunchInOut(jsonRequestBody, Prefs.getToken()!);
      }
    }
  }

  Future<void> getDirectAndIndirectTasks() async {
    await _blocEmployee.getDirectTasks(Prefs.getToken()!);
    await _blocEmployee.getIndirectTasks(Prefs.getToken()!);
  }

  YYDialog showDialog(int type, int status) {
    return YYDialog().build(context)
      ..width = 300
      ..backgroundColor = CustomColors.white_color
      ..barrierColor = Colors.black.withOpacity(.6)
      ..animatedFunc = (child, animation) {
        return ScaleTransition(
          child: child,
          scale: Tween(begin: 0.0, end: 1.0).animate(animation),
        );
      }
      ..borderRadius = 10.0
      ..text(
          textAlign: TextAlign.center,
          padding: EdgeInsets.fromLTRB(10, 20, 10, 20),
          color: CustomColors.black_font_color,
          fontSize: 20.0,
          text: "If you will be Lunch-In or Break-In, then your current task will be stopped.")
      ..divider()
      ..doubleButton(
        gravity: Gravity.spaceEvenly,
        padding: EdgeInsets.only(top: 10.0),
        withDivider: true,
        text1: "No",
        color1: CustomColors.blue_font_color,
        fontSize1: 14.0,
        fontWeight1: FontWeight.bold,
        onTap1: () async {
        },

        text2: "Yes",
        color2: CustomColors.blue_font_color,
        fontSize2: 14.0,
        fontWeight2: FontWeight.bold,
        onTap2: () async {
          getBreakLunchInOut(type, status);
        },
      )
      ..show();
  }
}
