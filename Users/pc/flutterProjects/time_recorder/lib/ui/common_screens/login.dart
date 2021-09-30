import 'dart:convert';

import 'package:device_info/device_info.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/scheduler.dart';
import 'package:flutter/services.dart';
import 'package:time_recorder/bloc/login_bloc.dart';
import 'package:time_recorder/data_layer/User.dart';
import 'package:time_recorder/theme/colors.dart';
import 'package:time_recorder/ui/common_screens/forgot_pass_screens/take_email.dart';
import 'package:time_recorder/ui/common_screens/register.dart';
import 'package:time_recorder/ui/employee_screens/employee.dart';
import 'package:time_recorder/ui/supervisor_screens/supervisor.dart';
import 'package:time_recorder/utils/global.dart';
import 'package:time_recorder/utils/prefs.dart';

class Login extends StatefulWidget {
  const Login({Key? key, required this.roleType}) : super(key: key);

  final int roleType;

  @override
  _LoginState createState() => _LoginState();
}

class _LoginState extends State<Login> {
  late LoginBloc _blocLogin;

  late TextEditingController _controllerEmail;
  late TextEditingController _controllerPassword;

  @override
  void initState() {
    getInitialWorkDone();

    _blocLogin = LoginBloc();

    _controllerEmail = TextEditingController();
    _controllerPassword = TextEditingController();

    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Center(
            child: Column(
          children: [
            SizedBox(
              height: 50,
            ),
            Image.asset(
              "assets/logo_background_blue.png",
              width: 120,
              height: 120,
            ),
            Text(
              "Time Recorder",
              style: TextStyle(
                  fontSize: 20,
                  color: CustomColors.blue_font_color,
                  fontWeight: FontWeight.bold),
            ),
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  SizedBox(
                    height: 40,
                  ),
                  Text(
                    "Email",
                    textAlign: TextAlign.start,
                    style: TextStyle(
                      fontSize: 20,
                      color: CustomColors.grey_color,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  StreamBuilder<String>(
                    stream: _blocLogin.email,
                    builder: (context, snapshot) {
                      return TextField(
                          controller: _controllerEmail,
                          onChanged: (value) {
                            _blocLogin.setEmail(value);
                          },
                          decoration: InputDecoration(
                            errorText: snapshot.error == null
                                ? null
                                : snapshot.error.toString(),
                            hintText: "E-mail",
                          ));
                    },
                  ),
                  SizedBox(
                    height: 40,
                  ),
                  Text(
                    "Password",
                    textAlign: TextAlign.start,
                    style: TextStyle(
                        fontSize: 20,
                        color: CustomColors.grey_color,
                        fontWeight: FontWeight.bold),
                  ),
                  StreamBuilder<String>(
                      stream: _blocLogin.password,
                      builder: (context, snapshot) {
                        return TextField(
                            controller: _controllerPassword,
                            onChanged: (value) {
                              _blocLogin.setPassword(value);
                            },);
                      }),
                  SizedBox(
                    height: 10,
                  ),
                  SizedBox(
                    width: double.infinity,
                    child: GestureDetector(
                      onTap: () => Navigator.push(context, MaterialPageRoute(builder: (context) => TakeEmail(roleType: widget.roleType))),
                      child: Text(
                        "Forgot Password?",
                        textAlign: TextAlign.end,
                        style: TextStyle(
                          fontSize: 20,
                          color: CustomColors.blue_font_color,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ),
                  ),
                  SizedBox(
                    height: 40,
                  ),
                  SizedBox(
                    width: double.infinity,
                    child: StreamBuilder<User>(
                        stream: _blocLogin.stream,
                        builder: (context, snapshot) {
                          final user = snapshot.data;
                          if (user != null) {
                            if (user.isLogin) {
                              Prefs.setLoginStatus(user.isLogin);
                              Prefs.setFirstName(user.firstName);
                              Prefs.setLastName(user.lastName);
                              Prefs.setEmail(user.emailId);
                              Prefs.setProfileImageUrl(user.profileUrl);
                              Prefs.setUserId(user.userId.toString());
                              Prefs.setToken(user.token);
                              Prefs.setRole(user.role.toString());
                              SchedulerBinding.instance!
                                  .addPostFrameCallback((_) {
                                if (Prefs.getLoginStatus()!) {
                                  if (Prefs.getRole() == "1") {
                                    Navigator.pushReplacement(
                                        context,
                                        MaterialPageRoute(
                                            builder: (context) =>
                                                (Supervisor())));
                                  } else {
                                    Navigator.pushReplacement(
                                        context,
                                        MaterialPageRoute(
                                            builder: (context) =>
                                                (Employee())));
                                  }
                                }
                              });
                            }
                          }
                          return ElevatedButton(
                              onPressed: getUserLogin, child: Text("Login"));
                        }),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Text("Don't have an account?"),
                      GestureDetector(
                        onTap: () => Navigator.pushReplacement(
                            context,
                            MaterialPageRoute(
                                builder: (context) =>
                                    Register(roleType: widget.roleType))),
                        child: Text(
                          "Sign Up",
                          style: TextStyle(color: CustomColors.blue_color),
                        ),
                      ),
                    ],
                  )
                ],
              ),
            ),
          ],
        )),
      ),
    );
  }

  Future<void> getUserLogin() async {
    String deviceId = await getDeviceId();
    if (_controllerEmail.text.isEmpty ||
        _controllerEmail.text.length == 0 ||
        !_controllerEmail.text.contains('@')) {
      if (_controllerEmail.text.isEmpty || _controllerEmail.text.length == 0) {
        Global.showToast("Email can not be empty.");
      } else {
        Global.showToast("Email is invalid");
      }
    } else if (_controllerPassword.text.isEmpty ||
        _controllerPassword.text.length ==
            0 /*|| _controllerPassword.text.length < 6*/) {
      /* if (_controllerPassword.text.isEmpty || _controllerPassword.text.length == 0) {
        Global.showToast("Password can not be empty.");
      } else {
        Global.showToast("Password Can not be less than 6 character");
      }*/
      Global.showToast("Password can not be empty.");
    } else {
      var json = jsonEncode(<String, dynamic>{
        "emailId": _controllerEmail.text.toString(),
        "password": _controllerPassword.text.toString(),
        "role": widget.roleType,
        "deviceId": deviceId
      });

      print("prindn $json");
      _blocLogin.getUserLogin(json);
    }
  }

  Future<String> getDeviceId() async {
    try {
      DeviceInfoPlugin deviceInfo = DeviceInfoPlugin();
      AndroidDeviceInfo androidInfo = await deviceInfo.androidInfo;
      print("drcceic ${androidInfo.androidId}");
      return androidInfo.androidId.toString();
    } on PlatformException {
      Global.showToast("Error:': 'Failed to get platform version.");
      return "";
    }
  }

  Future<void> getInitialWorkDone() async {
    await Prefs.init();
  }
}
