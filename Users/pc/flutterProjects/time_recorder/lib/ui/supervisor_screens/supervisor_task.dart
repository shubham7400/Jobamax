import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_custom_dialog/flutter_custom_dialog.dart';
import 'package:time_recorder/bloc/supervisor_bloc.dart';
import 'package:time_recorder/data_layer/Task.dart';
import 'package:time_recorder/theme/colors.dart';
import 'package:time_recorder/ui/supervisor_screens/update_task.dart';
import 'package:time_recorder/utils/prefs.dart';

class SupervisorTask extends StatefulWidget {
  const SupervisorTask({Key? key}) : super(key: key);

  @override
  _SupervisorTaskState createState() => _SupervisorTaskState();
}

class _SupervisorTaskState extends State<SupervisorTask> {

  late SupervisorBloc _blocSupervisor;

  @override
  void initState() {
    _blocSupervisor = SupervisorBloc();

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
                    _buildDirectTaskList(_blocSupervisor),
                    SizedBox(
                      width: 10,
                    ),
                    _buildIndirectTaskList(_blocSupervisor),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget taskWidget(Task task) {
    return GestureDetector(
      onTap: () => showDialog(context, task),
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

  Future<void> getDirectAndIndirectTasks() async {
    await _blocSupervisor.getDirectTasks(Prefs.getToken()!);
    await _blocSupervisor.getIndirectTasks(Prefs.getToken()!);
  }

  Future<void> getInitialWorkDone() async {
    await Prefs.init();
  }

  Widget _buildDirectTaskList(SupervisorBloc blocSupervisor) {
    return StreamBuilder<List<Task>>(
        stream: blocSupervisor.directTask,
        builder: (context, snapshot) {
          // 1
          final results = snapshot.data;

          if (results == null) {
            return Center(child: Text('No Direct Task'));
          }

          if (results.isEmpty) {
            return Center(child: Text('No Results'));
          }

          return list(results);
        }
    );

  }

  Widget _buildIndirectTaskList(SupervisorBloc blocSupervisor) {
    return StreamBuilder<List<Task>>(
        stream: blocSupervisor.indirectTask,
        builder: (context, snapshot) {
          // 1
          final results = snapshot.data;

          if (results == null) {
            return Center(child: Text('No Indirect Task'));
          }

          if (results.isEmpty) {
            return Center(child: Text('No Results'));
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

              return taskWidget(task);
            }),
      ),
    );
  }


  YYDialog showDialog(BuildContext context, Task task) {
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
          text: "Do you want to edit this task?")
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
          Navigator.push(context, MaterialPageRoute(builder: (context) => UpdateTask(task),),).then((value) {
            _blocSupervisor.getDirectTasks(Prefs.getToken()!);
            _blocSupervisor.getIndirectTasks(Prefs.getToken()!);
          });
        },
      )
      ..show();
  }


}
