 import 'dart:convert' show json;
import 'dart:io';
import 'package:http/http.dart' as http;
 import 'package:time_recorder/data_layer/User.dart';
import 'package:time_recorder/utils/constants.dart';
import 'package:time_recorder/utils/global.dart';

import 'dart:async';



class ApiClient {

  final _host = 'applligent.com';
  final _contextRoot = 'adi_projects/time_recorder/api/v1';


  Future<void> getRegister(String parameters) async {
    var _headers =  {
      'Content-Type': 'application/json; charset=UTF-8'
    };

    final uri = Uri.https(_host, '$_contextRoot/$SIGNUP');
    final results = await http.post(uri, headers: _headers, body: parameters);
    final jsonObject = json.decode(results.body);
    if(jsonObject["statusCode"] == 200){
      if(jsonObject["success"]){
        Global.showToast(jsonObject["message"]);
        var user = User.fromJson(jsonObject["data"]);
      }else{
        Global.showToast(jsonObject["message"]);
      }
    }else{
      Global.showToast(jsonObject["message"]);
    }

  }


  Future<dynamic> getUserLogin(String parameters) async {
    var _headers =  {
      'Content-Type': 'application/json; charset=UTF-8'
    };
     print(parameters);
    final uri = Uri.https(_host, '$_contextRoot/$LOGIN');
    final results = await http.post(uri, headers: _headers, body: parameters);
    return json.decode(results.body);

  }

  Future<dynamic> updateUser(String parameters, String token) async {
    var _headers =  {
      HttpHeaders.authorizationHeader: token,
      'Content-Type': 'application/json; charset=UTF-8'
    };
    print(parameters);
    final uri = Uri.https(_host, '$_contextRoot/$UPDATE_USER_PROFILE');
    final results = await http.post(uri, headers: _headers, body: parameters);
    return json.decode(results.body);
  }

  Future<dynamic> createTask(String parameters, String token) async {
    var _headers =  {
      HttpHeaders.authorizationHeader: token,
      'Content-Type': 'application/json; charset=UTF-8'
    };
    print(parameters);
    final uri = Uri.https(_host, '$_contextRoot/$CREATE_TASK');
    final results = await http.post(uri, headers: _headers, body: parameters);
    return json.decode(results.body);
  }

  Future<dynamic> getDirectTasks(String token) async {
    var _headers =  {
      HttpHeaders.authorizationHeader: token,
      'Content-Type': 'application/json; charset=UTF-8'
    };
    final uri = Uri.https(_host, '$_contextRoot/$GET_DIRECT_TASK');
    final results = await http.get(uri, headers: _headers );
    return json.decode(results.body);
  }

  Future<dynamic> getIndirectTasks(String token) async {
    var _headers =  {
      HttpHeaders.authorizationHeader: token,
      'Content-Type': 'application/json; charset=UTF-8'
    };
    final uri = Uri.https(_host, '$_contextRoot/$GET_INDIRECT_TASK');
    final results = await http.get(uri, headers: _headers );
    return json.decode(results.body);
  }

  Future<dynamic> getTaskLogs(String token) async {
    var _headers =  {
      HttpHeaders.authorizationHeader: token,
      'Content-Type': 'application/json; charset=UTF-8'
    };
    final uri = Uri.https(_host, '$_contextRoot/$GET_TASK_LOGS');
    final results = await http.get(uri, headers: _headers );
    return json.decode(results.body);
  }

  Future<dynamic> getShiftTime(String token) async {
    var _headers =  {
      HttpHeaders.authorizationHeader: token,
      'Content-Type': 'application/json; charset=UTF-8'
    };
    final uri = Uri.https(_host, '$_contextRoot/$GET_SHIFT_TIME');
    final results = await http.get(uri, headers: _headers );
    return json.decode(results.body);
  }

  Future<dynamic> verifyEmail(String parameters) async {
    var _headers =  {
      'Content-Type': 'application/json; charset=UTF-8'
    };
    print(parameters);
    final uri = Uri.https(_host, '$_contextRoot/$FORGOT_PASS');
    final results = await http.post(uri, headers: _headers, body: parameters);
    return json.decode(results.body);
  }

  Future<dynamic> verifyOtp(String parameters) async {
    var _headers =  {
      'Content-Type': 'application/json; charset=UTF-8'
    };
    print(parameters);
    final uri = Uri.https(_host, '$_contextRoot/$VERIFY_OTP');
    final results = await http.post(uri, headers: _headers, body: parameters);
    return json.decode(results.body);
  }

  Future<dynamic> resetPassword(String parameters) async {
    var _headers =  {
      'Content-Type': 'application/json; charset=UTF-8'
    };
    print(parameters);
    final uri = Uri.https(_host, '$_contextRoot/$RESET_PASSWORD');
    final results = await http.post(uri, headers: _headers, body: parameters);
    return json.decode(results.body);
  }

  Future<dynamic> stopTask(String parameters, String token) async {
    var _headers =  {
      HttpHeaders.authorizationHeader: token,
      'Content-Type': 'application/json; charset=UTF-8'
    };
    print(parameters);
    final uri = Uri.https(_host, '$_contextRoot/$START_STOP_TASK');
    final results = await http.post(uri, headers: _headers, body: parameters);
    return json.decode(results.body);
  }

  Future<dynamic> startTask(String parameters, String token) async {
    var _headers =  {
      HttpHeaders.authorizationHeader: token,
      'Content-Type': 'application/json; charset=UTF-8'
    };
    print(parameters);
    final uri = Uri.https(_host, '$_contextRoot/$START_STOP_TASK');
    final results = await http.post(uri, headers: _headers, body: parameters);
    return json.decode(results.body);
  }

  Future<dynamic> updateTask(String parameters, String token) async {
    var _headers =  {
      HttpHeaders.authorizationHeader: token,
      'Content-Type': 'application/json; charset=UTF-8'
    };
    print(parameters);
    final uri = Uri.https(_host, '$_contextRoot/$UPDATE_TASK');
    final results = await http.put(uri, headers: _headers, body: parameters);
    return json.decode(results.body);
  }

  Future<dynamic> getClockTimeStatus(String token) async {
    var _headers =  {
      HttpHeaders.authorizationHeader: token,
      'Content-Type': 'application/json; charset=UTF-8'
    };
    print(token);
    final uri = Uri.https(_host, '$_contextRoot/$CLOCK_TIME_STATUS');
    final results = await http.get(uri, headers: _headers );
    return json.decode(results.body);
  }

  Future<dynamic> getTotalTime(token, String parameters ) async {
    print(parameters);
    final uri = Uri.https(_host, '$_contextRoot/$TOTAL_TIME');
    final results = await http.post(uri, headers: {HttpHeaders.authorizationHeader: token,
      'Content-Type': 'application/json; charset=UTF-8'}, body: parameters);
    return json.decode(results.body);
  }

  Future<dynamic> getClockInOut(token, String parameters) async {
    print(parameters);
    final uri = Uri.https(_host, '$_contextRoot/$UPDATE_TASK');
    final results = await http.put(uri, headers: {HttpHeaders.authorizationHeader: token,
      'Content-Type': 'application/json; charset=UTF-8'}, body: parameters);
    return json.decode(results.body);
  }

  Future<dynamic> getBreakLunchInOut(String token, String parameters) async {
    print(parameters);
    final uri = Uri.https(_host, '$_contextRoot/$SAVE_BREAK_TIME');
    final results = await http.put(uri, headers: {HttpHeaders.authorizationHeader: token,
      'Content-Type': 'application/json; charset=UTF-8'}, body: parameters);
    return json.decode(results.body);
  }
}