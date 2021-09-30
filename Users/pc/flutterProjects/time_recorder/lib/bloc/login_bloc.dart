
import 'dart:async';

import 'package:rxdart/rxdart.dart';
import 'package:time_recorder/bloc/bloc.dart';
import 'package:time_recorder/data_layer/User.dart';
import 'package:time_recorder/network/api_client.dart';
import 'package:time_recorder/utils/global.dart';
import 'package:time_recorder/utils/validation.dart';

class LoginBloc extends Bloc with Validation {
  final _apiClient = ApiClient();

  final _controllerUser = StreamController<User>();
  Stream<User> get stream => _controllerUser.stream;

  final _email = BehaviorSubject<String>();
  Stream<String> get email => _email.stream.transform(eMailValidate);
  void setEmail(String value) => _email.sink.add(value);

  final _password = BehaviorSubject<String>();
  Stream<String> get password => _password.stream.transform(passwordValidate);
  void setPassword(String value) => _password.sink.add(value);

  @override
  void dispose() {
    _controllerUser.close();
    _email.close();
    _password.close();
  }

  Future<void> getUserLogin(String json) async {
    var jsonObject = await _apiClient.getUserLogin(json);
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

}