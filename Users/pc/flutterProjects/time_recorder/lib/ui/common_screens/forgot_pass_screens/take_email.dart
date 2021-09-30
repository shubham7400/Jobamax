import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/scheduler.dart';
import 'package:time_recorder/bloc/forgot_pass_bloc.dart';
import 'package:time_recorder/ui/common_screens/forgot_pass_screens/take_otp.dart';
import 'package:time_recorder/utils/global.dart';

class TakeEmail extends StatefulWidget {
  final roleType;

  const TakeEmail({Key? key, this.roleType}) : super(key: key);

  @override
  _TakeEmailState createState() => _TakeEmailState();
}

class _TakeEmailState extends State<TakeEmail> {
  late ForgotPassBloc _blocForgotPass;

  late TextEditingController _controllerEmail;


  @override
  void initState() {
    _blocForgotPass = ForgotPassBloc();

    _controllerEmail = TextEditingController();

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
              "Forgot Password",
              style: TextStyle(),
            ),

            SizedBox(height: 20,),

            Text(
              "Enter your email address to receive a verification code",
              style: TextStyle(),
            ),

            SizedBox(height: 40,),

            Container(
              width: double.infinity,
              alignment: Alignment.centerLeft,
              child: Text(
                "Email",
                style: TextStyle(),
              ),
            ),

            Material(
              child: TextField(
                controller: _controllerEmail,
              ),
            ),

            SizedBox(height: 50,),

            StreamBuilder<bool>(
              stream: _blocForgotPass.isVerifiedEmail,
              builder: (context, snapshot) {
                var data = snapshot.data;

                if(data == true){
                  SchedulerBinding.instance!.addPostFrameCallback((_) {
                    Navigator.push(context, MaterialPageRoute(builder: (context) => TakeOtp(email: _controllerEmail.text.toString())));
                  });
                }

                return SizedBox(
                  width: double.infinity,
                    child: ElevatedButton(
                        onPressed: verifyEmail,
                        child: Text("Send")),
                );
              }
            )
          ],
        ),
      ),
    );
  }

  void verifyEmail() {
    if (_controllerEmail.text.isEmpty || _controllerEmail.text.length == 0 || !_controllerEmail.text.contains('@')) {
      if (_controllerEmail.text.isEmpty || _controllerEmail.text.length == 0) {
        Global.showToast("Email can not be empty.");
      } else {
        Global.showToast("Email is invalid");
      }
    }else if(widget.roleType == null){
      Global.showToast("Please try again later");
    }else{
      var jsonRequestBody = jsonEncode(<String, dynamic>{
        "emailId": _controllerEmail.text.toString(),
        "role": widget.roleType
      });

      _blocForgotPass.verifyEmail(jsonRequestBody);
    }

  }
}
