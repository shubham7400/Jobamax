import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/scheduler.dart';
import 'package:time_recorder/bloc/forgot_pass_bloc.dart';
 import 'package:time_recorder/ui/common_screens/user_role.dart';
import 'package:time_recorder/utils/global.dart';

class TakeNewPass extends StatefulWidget {
  final userId;
  const TakeNewPass({Key? key, this.userId}) : super(key: key);

  @override
  _TakeNewPassState createState() => _TakeNewPassState();
}

class _TakeNewPassState extends State<TakeNewPass> {
  late ForgotPassBloc _blocForgotPass;

  late TextEditingController _controllerPassword;
  late TextEditingController _controllerConfirmedPassword;


  @override
  void initState() {
    _blocForgotPass = ForgotPassBloc();

    _controllerPassword = TextEditingController();
    _controllerConfirmedPassword = TextEditingController();

    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: const EdgeInsets.all(10.0),
        child: Column(
          children: [

            SizedBox(height: 20,),

            Container(
              width: double.infinity,
              alignment: Alignment.centerLeft,
              child: Image.asset("assets/back_arrow.png"),
            ),

            SizedBox(height: 40,),

            Text(
              "Reset Password",
              style: TextStyle(),
            ),

            SizedBox(height: 20,),

            Text(
              "Enter your new password ",
              style: TextStyle(),
            ),

            SizedBox(height: 40,),

            Container(
              width: double.infinity,
              alignment: Alignment.centerLeft,
              child: Text(
                "New Password",
                style: TextStyle(),
              ),
            ),


            Material(
              child: TextField(
                controller: _controllerPassword,
              ),
            ),

            SizedBox(height: 50,),

            Container(
              width: double.infinity,
              alignment: Alignment.centerLeft,
              child: Text(
                "Confirm Password",
                style: TextStyle(),
              ),
            ),

            Material(
              child: TextField(
                controller: _controllerConfirmedPassword,
              ),
            ),

            SizedBox(height: 50,),

            StreamBuilder<bool>(
                stream: _blocForgotPass.isPassReset,
                builder: (context, snapshot) {
                  var data = snapshot.data;

                  if(data == true){
                    SchedulerBinding.instance!.addPostFrameCallback((_) {
                      Navigator.of(context, rootNavigator: true).pushReplacement(MaterialPageRoute(builder: (context) => new UserRole()));
                    });
                  }

                  return SizedBox(
                    width: double.infinity,
                    child: ElevatedButton(
                        onPressed: resetPassword,
                        child: Text("Save")),
                  );
                }
            )
          ],
        ),
      ),
    );
  }

  void resetPassword() {
    if (_controllerPassword.text.isEmpty || _controllerPassword.text.length == 0 ) {
      Global.showToast("Password can not be empty");
    }else if(_controllerConfirmedPassword.text.isEmpty || _controllerConfirmedPassword.text.length == 0 ){
      Global.showToast("Confirmed Password can not be empty");
    }else if(_controllerPassword.text.toString() != _controllerConfirmedPassword.text.length.toString() ){
      Global.showToast("Password and Confirm Password does not match");
    }else{
      var jsonRequestBody = jsonEncode(<String, dynamic>{
        "userId": widget.userId,
        "password": _controllerPassword.text.toString()
      });

      _blocForgotPass.resetPassword(jsonRequestBody);
    }

  }
}
