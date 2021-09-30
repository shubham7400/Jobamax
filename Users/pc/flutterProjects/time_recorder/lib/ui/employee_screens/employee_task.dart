import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_custom_dialog/flutter_custom_dialog.dart';
import 'package:time_recorder/bloc/employee_bloc.dart';
import 'package:time_recorder/data_layer/Task.dart';
import 'package:time_recorder/theme/colors.dart';
import 'package:time_recorder/utils/prefs.dart';

class EmployeeTask extends StatefulWidget {
  const EmployeeTask({Key? key}) : super(key: key);

  @override
  _EmployeeTaskState createState() => _EmployeeTaskState();
}

class _EmployeeTaskState extends State<EmployeeTask> {
  late EmployeeBloc _blocEmployee;

  List<Task> listOfDirectTask = [];
  List<Task> listOfIndirectTask = [];

  @override
  void initState() {
    _blocEmployee = EmployeeBloc();
     getInitialWorkDone();
    getDirectAndIndirectTasks();
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Column(
          children: [
            Material(
              elevation: 5,
              child: Container(
                alignment: Alignment.center,
                width: double.infinity,
                height: 50,
                child: Text(
                  "TASK",
                  style: TextStyle(
                    color: CustomColors.blue_font_color,
                    fontWeight: FontWeight.bold,
                    fontSize: 25,
                  ),
                ),
              ),
            ),
            SizedBox(
              height: 4,
            ),
            Row(
              crossAxisAlignment: CrossAxisAlignment.start,
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                Flexible(
                  child: Material(
                    elevation: 1,
                    child: Container(
                      alignment: Alignment.center,
                      height: 40,
                      child: Text(
                        "Direct Task",
                      ),
                    ),
                  ),
                ),
                SizedBox(
                  width: 10,
                ),
                Flexible(
                  child: Material(
                    elevation: 1,
                    child: Container(
                      height: 40,
                      alignment: Alignment.center,
                      child: Text(
                        "Indirect Task",
                        style: TextStyle(),
                      ),
                    ),
                  ),
                )
              ],
            ),
            SizedBox(
              height: 10,
            ),
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: Container(
                height: 500,
                child: Row(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: [
                    _buildDirectTaskList(_blocEmployee),
                    SizedBox(
                      width: 10,
                    ),
                    _buildIndirectTaskList(_blocEmployee),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }


  Future<void> getDirectAndIndirectTasks() async {
    await _blocEmployee.getDirectTasks(Prefs.getToken()!);
    await _blocEmployee.getIndirectTasks(Prefs.getToken()!);
  }

  Future<void> getInitialWorkDone() async {
    await Prefs.init();
  }

  Widget _buildDirectTaskList(EmployeeBloc blocEmployee) {
    return StreamBuilder<List<Task>>(
        stream: blocEmployee.directTask,
        builder: (context, snapshot) {
          // 1
          final results = snapshot.data;

          if (results == null) {
            return Center(child: Text('No Direct Task'));
          }

          if (results.isEmpty) {
            return Center(child: Text('No Results'));
          }

          if(results.isNotEmpty){
            if(listOfDirectTask.isEmpty){
              listOfDirectTask = results;
            }else{
              listOfDirectTask = [];
              listOfDirectTask = results;
            }
          }

          return list(results);
        }
    );

  }

  Widget _buildIndirectTaskList(EmployeeBloc blocEmployee) {
    return StreamBuilder<List<Task>>(
        stream: blocEmployee.indirectTask,
        builder: (context, snapshot) {
          // 1
          final results = snapshot.data;

          if (results == null) {
            return Center(child: Text('No Indirect Task'));
          }

          if (results.isEmpty) {
            return Center(child: Text('No Results'));
          }

          if(results.isNotEmpty){
            if(listOfIndirectTask.isEmpty){
              listOfIndirectTask = results;
            }else{
              listOfIndirectTask = [];
              listOfIndirectTask = results;
            }
          }

          return list(results);
        }
    );
  }

  Widget list(List<Task> tasks) {

    return Flexible(
      child: Container(
        child: ListView.builder(
            itemCount: tasks.length,
            itemBuilder: (context, index) {
              final task = tasks[index];
              if(task.isActive){
               /* Prefs.setTaskStatus(task.taskId);*/
                return activeTaskWidget(task);
              }else{
                return inactiveTaskWidget(task);
              }
            }),
      ),
    );
  }

  Widget activeTaskWidget(Task task) {
    return GestureDetector(
      onTap: ()  {
        if(task.isActive){
          var jsonRequestBody = jsonEncode(<String, dynamic>{
            "type": 2,
            "startTime": "",
            "stopTime": (DateTime.now().millisecondsSinceEpoch / 1000),
            "taskId": task.taskId
          });
          _blocEmployee.stopTask(jsonRequestBody, Prefs.getToken()!);
        }
      },
      child: Container(
        height: 50,
        margin: EdgeInsets.fromLTRB(0, 0, 0, 5),
        alignment: Alignment.center,
        decoration: BoxDecoration(
          color: CustomColors.yellow_color,
          borderRadius: BorderRadius.circular(10.0),
        ),
        child: Padding(
          padding: const EdgeInsets.all(5.0),
          child: Text(
              task.title,
            textAlign: TextAlign.center,
          ),
        ),
      ),
    );
  }

  Widget inactiveTaskWidget(Task task) {
    return GestureDetector(
      onTap: () {
        var activeTaskId = -1;

        listOfDirectTask.forEach((directTask) {
          if(directTask.isActive){
            activeTaskId = directTask.taskId;
          }
        });

        listOfIndirectTask.forEach((indirectTask) {
          if(indirectTask.isActive){
            activeTaskId = indirectTask.taskId;
          }
        });

        if(activeTaskId == -1){
          var jsonRequestBody = jsonEncode(<String, dynamic>{
            "type": 1,
            "startTime": (DateTime.now().millisecondsSinceEpoch / 1000),
            "stopTime": "",
            "taskId": task.taskId
          });
          _blocEmployee.startTask(jsonRequestBody, Prefs.getToken()!);
        }else{
          var jsonRequestBody = jsonEncode(<String, dynamic>{
            "type": 2,
            "startTime": "",
            "stopTime": (DateTime.now().millisecondsSinceEpoch / 1000),
            "taskId": activeTaskId
          });

          var jsonRequestBodyToStartTask = jsonEncode(<String, dynamic>{
            "type": 1,
            "startTime": (DateTime.now().millisecondsSinceEpoch / 1000),
            "stopTime": "",
            "taskId": task.taskId
          });
          showDialog(context, jsonRequestBody, jsonRequestBodyToStartTask);
        }
      },
      child: Container(
        height: 50,
        margin: EdgeInsets.fromLTRB(0, 0, 0, 5),
        alignment: Alignment.center,
        decoration: BoxDecoration(
          border: Border.all(
            color: CustomColors.grey_color,
          ),
          borderRadius: BorderRadius.circular(10.0),
        ),
        child: Padding(
          padding: const EdgeInsets.all(5.0),
          child: Text(
              task.title,
            textAlign: TextAlign.center,
          ),
        ),
      ),
    );
  }


  YYDialog showDialog(BuildContext context, String jsonRequestBody, String jsonRequestBodyToStartTask) {
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
          text: "If you will start this task, then your current task will be stopped.")
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
          _blocEmployee.stopAndStartTask(jsonRequestBody, Prefs.getToken()!, jsonRequestBodyToStartTask);
        },
      )
      ..show();
  }

}
