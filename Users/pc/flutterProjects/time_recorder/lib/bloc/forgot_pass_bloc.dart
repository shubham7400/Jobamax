import 'dart:async';
import 'dart:collection';

import 'package:time_recorder/bloc/bloc.dart';
import 'package:time_recorder/network/api_client.dart';
import 'package:time_recorder/utils/global.dart';

class ForgotPassBloc extends Bloc {
  final _apiClient = ApiClient();


  final _controllerEmail = StreamController<bool>.broadcast();
  Stream<bool> get isVerifiedEmail => _controllerEmail.stream   ;

  final _controllerOtp = StreamController<Map<String, dynamic>>.broadcast();
  Stream<Map<String, dynamic>> get isVerifiedOtp => _controllerOtp.stream ;

  final _controllerResetPassword = StreamController<bool>.broadcast();
  Stream<bool> get isPassReset => _controllerResetPassword.stream ;

  @override
  void dispose() {
    _controllerEmail.close();
    _controllerOtp.close();
    _controllerResetPassword.close();
  }


  Future<void> verifyEmail(String jsonBody) async {
    var jsonObject = await _apiClient.verifyEmail(jsonBody);
    print(jsonObject);
    if(jsonObject["statusCode"] == 200){
      if(jsonObject["success"]){
        Global.showToast(jsonObject["message"]);
        var isVerifiedEmail = jsonObject["status"] as bool;
        _controllerEmail.sink.add(isVerifiedEmail);
      }else{
        Global.showToast(jsonObject["message"]);
      }
    }else{
      Global.showToast(jsonObject["message"]);
    }
  }

  Future<void> verifyOtp(String jsonRequestBody) async {
    var jsonObject = await _apiClient.verifyOtp(jsonRequestBody);
    print(jsonObject);
    if(jsonObject["statusCode"] == 200){
      if(jsonObject["success"]){
        Global.showToast(jsonObject["message"]);
        var map = HashMap<String, dynamic>();
        map["status"] = jsonObject["status"] as bool;
        map["userId"] = jsonObject["userId"] as int;
        _controllerOtp.sink.add(map);
      }else{
        Global.showToast(jsonObject["message"]);
      }
    }else{
      Global.showToast(jsonObject["message"]);
    }
  }

  Future<void> resetPassword(String jsonRequestBody) async {
    var jsonObject = await _apiClient.resetPassword(jsonRequestBody);
    print(jsonObject);
    if(jsonObject["statusCode"] == 200){
      if(jsonObject["success"]){
        Global.showToast(jsonObject["message"]);

        var isPassReset = jsonObject["success"] as bool;

        _controllerResetPassword.sink.add(isPassReset);
      }else{
        Global.showToast(jsonObject["message"]);
      }
    }else{
      Global.showToast(jsonObject["message"]);
    }
  }

}