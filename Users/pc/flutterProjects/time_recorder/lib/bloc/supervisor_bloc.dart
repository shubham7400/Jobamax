import 'dart:async';

import 'package:time_recorder/bloc/bloc.dart';
import 'package:time_recorder/data_layer/Task.dart';
import 'package:time_recorder/data_layer/User.dart';
import 'package:time_recorder/network/api_client.dart';
import 'package:time_recorder/utils/global.dart';

class SupervisorBloc extends Bloc {

  final _apiClient = ApiClient();

  final _controllerUser = StreamController<User>();
  Stream<User> get user => _controllerUser.stream;

  final _controllerDirectTask = StreamController<List<Task>>();
  Stream<List<Task>> get directTask => _controllerDirectTask.stream;

  final _controllerIndirectTask = StreamController<List<Task>>();
  Stream<List<Task>> get indirectTask => _controllerIndirectTask.stream;

  final _controllerUpdateTask = StreamController<bool>();
  Stream<bool> get isUpdateTask => _controllerUpdateTask.stream;

  @override
  void dispose() {
    _controllerUser.close();
    _controllerDirectTask.close();
    _controllerIndirectTask.close();
    _controllerUpdateTask.close();
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

  Future<void> createTask(String jsonRequestBody, String token) async {
    var jsonObject = await _apiClient.createTask(jsonRequestBody, token);
    print(token);
    print(jsonObject);
    if(jsonObject["statusCode"] == 200){
      if(jsonObject["success"]){
        Global.showToast(jsonObject["message"]);
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
       /* Global.showToast(jsonObject["message"]);*/
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
    print(jsonObject);
    print(jsonObject);
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

  Future<void> updateTask(String jsonRequestBody, String token) async {
    var jsonObject = await _apiClient.updateTask(jsonRequestBody, token);
    print(jsonObject);
    if(jsonObject["statusCode"] == 200){
      if(jsonObject["success"]){
        Global.showToast(jsonObject["message"]);
        var isUpdatedTask = jsonObject["success"] as bool;

        _controllerUpdateTask.sink.add(isUpdatedTask);
      }else{
        Global.showToast(jsonObject["message"]);
      }
    }else{
      Global.showToast(jsonObject["message"]);
    }
  }

}