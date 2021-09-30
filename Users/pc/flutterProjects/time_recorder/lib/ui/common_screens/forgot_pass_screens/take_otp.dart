import 'dart:convert';
import 'dart:math';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/scheduler.dart';
import 'package:otp_text_field/otp_field.dart';
import 'package:otp_text_field/style.dart';
import 'package:time_recorder/bloc/forgot_pass_bloc.dart';
import 'package:time_recorder/ui/common_screens/forgot_pass_screens/take_new_pass.dart';
import 'package:time_recorder/utils/global.dart';

class TakeOtp extends StatefulWidget {
  final email;
  const TakeOtp({Key? key, this.email}) : super(key: key);

  @override
  _TakeOtpState createState() => _TakeOtpState();
}

class _TakeOtpState extends State<TakeOtp> {
  late ForgotPassBloc _blocForgotPass;
  int otp = 0;

  @override
  void initState() {
    _blocForgotPass = ForgotPassBloc();

    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: const EdgeInsets.all(10.0),
        child: SingleChildScrollView(
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
                "Verification Code",
                style: TextStyle(),
              ),

              SizedBox(height: 20,),

              Text(
                "Code has been sent to ${widget.email}",
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

              OTPTextField(
                length: 6,
                width: MediaQuery.of(context).size.width,
                fieldWidth: 25,
                style: TextStyle(
                    fontSize: 17
                ),
                textFieldAlignment: MainAxisAlignment.spaceAround,
                fieldStyle: FieldStyle.underline,
                onCompleted: (pin) {
                  otp = int.parse(pin);
                },
              ),

              SizedBox(height: 50,),

              StreamBuilder<Map<String,dynamic>>(
                  stream: _blocForgotPass.isVerifiedOtp,
                  builder: (context, snapshot) {

                    var data = snapshot.data;

                    print("nsdpassot");
                    print(data);

                    if(data != null){
                      var status = data["status"] as bool;
                      var userId = data["userId"] as int;

                      if(status){
                        SchedulerBinding.instance!.addPostFrameCallback((_) {
                          Navigator.push(context, MaterialPageRoute(builder: (context) => TakeNewPass(userId: userId)));
                        });
                      }
                    }


                    return SizedBox(
                      width: double.infinity,
                      child: ElevatedButton(
                          onPressed: verifyOtp,
                          child: Text("verify")),
                    );
                  }
              )
            ],
          ),
        ),
      ),
    );
  }

  void verifyOtp() {
    if(otp.toString().length < 6){
      Global.showToast("Please enter full otp.");
    }else{
      var jsonRequestBody = jsonEncode(<String, dynamic>{
        "emailId": widget.email.toString(),
        "otp": otp
      });
      _blocForgotPass.verifyOtp(jsonRequestBody);
    }
  }
}
