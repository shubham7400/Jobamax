import 'dart:async';

import 'package:time_recorder/bloc/bloc.dart';
import 'package:time_recorder/data_layer/BreakLunchInOut.dart';
import 'package:time_recorder/data_layer/ClockInOut.dart';
import 'package:time_recorder/data_layer/ClockStatus.dart';
import 'package:time_recorder/data_layer/Shift.dart';
import 'package:time_recorder/data_layer/Task.dart';
import 'package:time_recorder/data_layer/TaskLog.dart';
import 'package:time_recorder/data_layer/TimeStatus.dart';
import 'package:time_recorder/data_layer/User.dart';
import 'package:time_recorder/network/api_client.dart';
import 'package:time_recorder/utils/global.dart';

class EmployeeBloc extends Bloc {
  final _apiClient = ApiClient();

  final _controllerUser = StreamController<User>();
  Stream<User> get stream => _controllerUser.stream;

  final _controllerDirectTask = StreamController<List<Task>>();
  Stream<List<Task>> get directTask => _controllerDirectTask.stream;

  final _controllerIndirectTask = StreamController<List<Task>>();
  Stream<List<Task>> get indirectTask => _controllerIndirectTask.stream;

  final _controllerTaskLogs = StreamController<List<TaskLog>>();
  Stream<List<TaskLog>> get taskLogs => _controllerTaskLogs.stream;

  final _controllerShift = StreamController<Shift>();
  Stream<Shift> get shift => _controllerShift.stream;

  final _controllerClockStatus = StreamController<ClockStatus>();
  Stream<ClockStatus> get clockStatus => _controllerClockStatus.stream;

  final _controllerTimeStatus = StreamController<TimeStatus>();
  Stream<TimeStatus> get timeStatus => _controllerTimeStatus.stream;

  final _controllerInOut = StreamController<ClockInOut>();
  Stream<ClockInOut> get clockInOut => _controllerInOut.stream;

  final _controllerBreakLunchInOut = StreamController<BreakLunchInOut>();
  Stream<BreakLunchInOut> get breakLunchInOut => _controllerBreakLunchInOut.stream;

  @override
  void dispose() {
    _controllerUser.close();
    _controllerDirectTask.close();
    _controllerIndirectTask.close();
    _controllerTaskLogs.close();
    _controllerShift.close();
    _controllerClockStatus.close();
    _controllerTimeStatus.close();
    _controllerInOut.close();
    _controllerBreakLunchInOut.close();
  }

  Future<void> updateUser(String jsonBody, String token) async {
    var jsonObject = await _apiClient.updateUser(jsonBody, token);
    print(token);
    print(jsonObject);
    if(jsonObject["statusCode"] == 200){
      if(jsonObject["success"]){
        Global.showToast(jsonObject["message"]);
        var user = User.fromJson(jsonObject["data"]);
        _controllerUser.sink.add(user);
      }else{
        Global.showToast(jsonObject["message"]);
      }
    }else{
      Global.showToast(jsonObject["message"]);
    }
  }

  Future<void> getDirectTasks(String token) async {
    var jsonObject = await _apiClient.getDirectTasks(token);
    print(token);
    print(jsonObject["data"]);
    if(jsonObject["statusCode"] == 200){
      if(jsonObject["success"]){
        /*Global.showToast(jsonObject["message"]);*/
        var directTasks = jsonObject["data"].map<Task>((json) => Task.fromJson(json)).toList(growable: false) as List<Task>;
        _controllerDirectTask.sink.add(directTasks);
      }else{
        Global.showToast(jsonObject["message"]);
      }
    }else{
      Global.showToast(jsonObject["message"]);
    }
  }

  Future<void> getIndirectTasks(String token) async {
    var jsonObject = await _apiClient.getIndirectTasks( token);
    print(token);
    if(jsonObject["statusCode"] == 200){
      if(jsonObject["success"]){
       /* Global.showToast(jsonObject["message"]);*/
        var indirectTasks = jsonObject["data"].map<Task>((json) => Task.fromJson(json)).toList(growable: false)as List<Task>;
        _controllerIndirectTask.sink.add(indirectTasks);
      }else{
        Global.showToast(jsonObject["message"]);
      }
    }else{
      Global.showToast(jsonObject["message"]);
    }
  }

  Future<void> getTaskLogs(String token) async {
    var jsonObject = await _apiClient.getTaskLogs( token);
    print(jsonObject);
    if(jsonObject["statusCode"] == 200){
      if(jsonObject["success"]){
        Global.showToast(jsonObject["message"]);
        var taskLogs = jsonObject["data"].map<TaskLog>((json) => TaskLog.fromJson(json)).toList(growable: false)as List<TaskLog>;
        _controllerTaskLogs.sink.add(taskLogs);
      }else{
        Global.showToast(jsonObject["message"]);
      }
    }else{
      Global.showToast(jsonObject["message"]);
    }
  }

  Future<void> getShiftTime(String token) async {
    var jsonObject = await _apiClient.getShiftTime( token);
    print(jsonObject);
    if(jsonObject["statusCode"] == 200){
      if(jsonObject["success"]){
        Global.showToast(jsonObject["message"]);
        var shift = Shift.fromJson(jsonObject["data"]);
        _controllerShift.sink.add(shift);
      }else{
        Global.showToast(jsonObject["message"]);
      }
    }else{
      Global.showToast(jsonObject["message"]);
    }
  }

  Future<void> stopTask(String jsonRequestBody, String token  ) async {
    var jsonObject = await _apiClient.stopTask(jsonRequestBody, token);
    print(token);
    print(jsonObject);
    if(jsonObject["statusCode"] == 200){
      if(jsonObject["success"]){
        Global.showToast(jsonObject["message"]);

        await getDirectTasks(token);
        await getIndirectTasks(token);
      }else{
        Global.showToast(jsonObject["message"]);
      }
    }else{
      Global.showToast(jsonObject["message"]);
    }
  }

  Future<void> startTask(String jsonRequestBody, String token) async {
    var jsonObject = await _apiClient.startTask(jsonRequestBody, token);
    print(token);
    print(jsonObject);
    if(jsonObject["statusCode"] == 200){
      if(jsonObject["success"]){
        Global.showToast(jsonObject["message"]);

        await getDirectTasks(token);
        await getIndirectTasks(token);
      }else{
        Global.showToast(jsonObject["message"]);
      }
    }else{
      Global.showToast(jsonObject["message"]);
    }
  }

  Future<void> stopAndStartTask(String jsonRequestBody, String token, String jsonRequestBodyToStartTask) async {
    var jsonObject = await _apiClient.stopTask(jsonRequestBody, token);
    print(token);
    print(jsonObject);
    if(jsonObject["statusCode"] == 200){
      if(jsonObject["success"]){
        Global.showToast(jsonObject["message"]);
        startTask(jsonRequestBodyToStartTask, token);

      }else{
        Global.showToast(jsonObject["message"]);
      }
    }else{
      Global.showToast(jsonObject["message"]);
    }
  }

  Future<void> getClockTimeStatus(String token) async {
    var jsonObject = await _apiClient.getClockTimeStatus( token);
    print(jsonObject);
    if(jsonObject["statusCode"] == 200){
      if(jsonObject["success"]){
        Global.showToast(jsonObject["message"]);
        var clockStatus = ClockStatus.fromJson(jsonObject["data"]);
        _controllerClockStatus.sink.add(clockStatus);
      }else{
        Global.showToast(jsonObject["message"]);
        ClockStatus.fromJson({
          "isClockedIn": false,
          "startTime": 1,
          "isBreak": false,
          "isLunch": false
        });
      }
    }else{
      Global.showToast(jsonObject["message"]);
    }
  }

  Future<void> getTotalTime(String token, String jsonRequestBody) async {
    var jsonObject = await _apiClient.getTotalTime( token, jsonRequestBody);
    print(jsonObject);
    if(jsonObject["statusCode"] == 200){
      if(jsonObject["success"]){
        Global.showToast(jsonObject["message"]);
        var timeStatus = TimeStatus.fromJson(jsonObject);
        _controllerTimeStatus.sink.add(timeStatus);
      }else{
        Global.showToast(jsonObject["message"]);
      }
    }else{
      Global.showToast(jsonObject["message"]);
    }
  }

  getClockInOut(String jsonRequestBody, String token) async {
    var jsonObject = await _apiClient.getClockInOut( token, jsonRequestBody);
    print(jsonObject);
    if(jsonObject["statusCode"] == 200){
      if(jsonObject["success"]){
        Global.showToast(jsonObject["message"]);
        var clockInOut = ClockInOut.fromJson(jsonObject);
        _controllerInOut.sink.add(clockInOut);
      }else{
        Global.showToast(jsonObject["message"]);
      }
    }else{
      Global.showToast(jsonObject["message"]);
    }
  }

  Future<void> getBreakLunchInOut(String jsonRequestBody, String token) async {
    var jsonObject = await _apiClient.getBreakLunchInOut( token, jsonRequestBody);
    print(jsonObject);
    if(jsonObject["statusCode"] == 200){
      if(jsonObject["success"]){
        Global.showToast(jsonObject["message"]);
        var breakLunchInOut = BreakLunchInOut.fromJson(jsonObject);
        _controllerBreakLunchInOut.sink.add(breakLunchInOut);
      }else{
        Global.showToast(jsonObject["message"]);
      }
    }else{
      Global.showToast(jsonObject["message"]);
    }
  }

}