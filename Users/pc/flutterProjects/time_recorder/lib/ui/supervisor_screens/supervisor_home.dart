import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:time_recorder/bloc/supervisor_bloc.dart';
import 'package:time_recorder/theme/colors.dart';
import 'package:time_recorder/utils/global.dart';
import 'package:time_recorder/utils/prefs.dart';

class SupervisorHome extends StatefulWidget {
  const SupervisorHome({Key? key}) : super(key: key);

  @override
  _SupervisorHomeState createState() => _SupervisorHomeState();
}

class _SupervisorHomeState extends State<SupervisorHome> {
  TaskType? _character = TaskType.direct;

  late SupervisorBloc _blocSupervisor;

  late TextEditingController _controllerTaskName;
  late TextEditingController _controllerTaskDescription;

  @override
  void initState() {
    _blocSupervisor = SupervisorBloc();

    _controllerTaskName = TextEditingController();
    _controllerTaskDescription = TextEditingController();

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
                      "HOME",
                    style: TextStyle(
                      color: CustomColors.blue_font_color,
                      fontWeight: FontWeight.bold,
                      fontSize: 25,
                    ),
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
                        onChanged: (TaskType? value) {
                          setState(() {
                            _character = value;
                            print("Direct $value");
                          });
                        },
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
                        onChanged: (TaskType? value) {
                          setState(() {
                            _character = value;
                            print("Indirect $value");
                          });
                        },
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
              child: ElevatedButton(
                onPressed: createTask,
                child: Text("Update"),

                ),
              ),
          ],
        ),
      ),
    );
  }


  void createTask(){
    if (_controllerTaskName.text.isEmpty || _controllerTaskName.text.length == 0) {
      Global.showToast(" Task Name can not be empty.");
    } else if (_controllerTaskDescription.text.isEmpty || _controllerTaskDescription.text.length == 0) {
      Global.showToast(" Task Description can not be empty.");
    } else if (_character == null ) {
      Global.showToast("Please select task type.");
    } else{
      var taskType = 1;
      if(_character == TaskType.direct){
        taskType = 1;
      }else{
        taskType = 2;
      }
      var jsonRequestBody = jsonEncode(<String, dynamic>{
        "title":_controllerTaskName.text.toString(),
        "description":_controllerTaskDescription.text.toString(),
        "taskType": taskType
      });

      print("println $json");
      _blocSupervisor.createTask(jsonRequestBody, Prefs.getToken()!);
    }
  }

  Future<void> getInitialWorkDone() async {
    await Prefs.init();
  }
}

enum TaskType { direct, indirect }
