import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:time_recorder/bloc/supervisor_bloc.dart';
import 'package:time_recorder/data_layer/Task.dart';
import 'package:time_recorder/theme/colors.dart';
import 'package:time_recorder/utils/global.dart';
import 'package:time_recorder/utils/prefs.dart';

class UpdateTask extends StatefulWidget {
  final Task task;
  const UpdateTask(this.task, {Key? key}) : super(key: key);

  @override
  _UpdateTaskState createState() => _UpdateTaskState();
}

class _UpdateTaskState extends State<UpdateTask> {
  TaskType? _character;

  late SupervisorBloc _blocSupervisor;

  late TextEditingController _controllerTaskName;
  late TextEditingController _controllerTaskDescription;

  @override
  void initState() {

    _character = widget.task.taskType == 1 ? TaskType.direct : TaskType.indirect;

    _blocSupervisor = SupervisorBloc();

    _controllerTaskName = TextEditingController();
    _controllerTaskDescription = TextEditingController();

    _controllerTaskName.text = widget.task.title;
    _controllerTaskDescription.text = widget.task.description;

    getInitialWorkDone();

    SystemChrome.setEnabledSystemUIOverlays([]);
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Material(
              elevation: 3,
              child: Container(
                alignment: Alignment.center,
                width: double.infinity,
                height: 50,
                child: Text(
                  "Update Task",
                ),
              ),
            ),
            SizedBox(height: 40,),
            Padding(
              padding: const EdgeInsets.all(10.0),
              child: Text("Task Type"),
            ),

            Padding(
              padding: const EdgeInsets.fromLTRB(10, 0, 10, 0),
              child: Row(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Flexible(
                    child: ListTile(
                      title: const Text('Direct Task'),
                      leading: Radio<TaskType>(
                        activeColor: CustomColors.blue_color,
                        value: TaskType.direct,
                        groupValue: _character,
                        onChanged: (TaskType? value) => null,
                      ),
                    ),
                  ),
                  Flexible(
                    child: ListTile(
                      title: const Text('Indirect Task'),
                      leading: Radio<TaskType>(
                        activeColor: CustomColors.blue_color,
                        value: TaskType.indirect,
                        groupValue: _character,
                        onChanged: (TaskType? value) => null,
                      ),
                    ),
                  )
                ],
              ),
            ),

            SizedBox(height: 20,),

            Padding(
              padding: const EdgeInsets.all(10.0),
              child: Material(
                elevation: 3,
                child: TextField(
                  controller: _controllerTaskName,
                  decoration: InputDecoration(
                      border: InputBorder.none,
                      contentPadding: const EdgeInsets.all(5),
                      hintText: "Enter Task Name..."
                  ),
                ),
              ),
            ),

            SizedBox(height: 10,),

            Padding(
              padding: const EdgeInsets.all(10.0),
              child: Material(
                elevation: 3,
                child: TextField(
                  controller: _controllerTaskDescription,
                  maxLines: 7,
                  decoration: InputDecoration(
                      border: InputBorder.none,
                      contentPadding: const EdgeInsets.all(5),
                      hintText: "Enter Task Description..."
                  ),
                ),
              ),
            ),

            SizedBox(height: 40,),

            Padding(
              padding: const EdgeInsets.fromLTRB(30, 0, 30, 0),
              child: StreamBuilder<bool>(
                stream: _blocSupervisor.isUpdateTask,
                builder: (context, snapshot) {
                  var isTaskUpdated = snapshot.data;
                  if(isTaskUpdated != null && isTaskUpdated){
                    Navigator.of(context).pop();
                  }
                  return ElevatedButton(
                    onPressed: updateTask,
                    child: Text("Update"),
                  );
                }
              ),
            ),
          ],
        ),
      ),
    );
  }


  void updateTask(){
    if (_controllerTaskName.text.isEmpty || _controllerTaskName.text.length == 0) {
      Global.showToast(" Task Name can not be empty.");
    } else if (_controllerTaskDescription.text.isEmpty || _controllerTaskDescription.text.length == 0) {
      Global.showToast(" Task Description can not be empty.");
    } else{

      var jsonRequestBody = jsonEncode(<String, dynamic>{
        "title":_controllerTaskName.text.toString(),
        "description":_controllerTaskDescription.text.toString(),
        "taskId": widget.task.taskId
      });

      print("println $json");
      _blocSupervisor.updateTask(jsonRequestBody, Prefs.getToken()!);
    }
  }

  Future<void> getInitialWorkDone() async {
    await Prefs.init();
  }
}

enum TaskType { direct, indirect }