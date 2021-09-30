import 'dart:async';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_custom_dialog/flutter_custom_dialog.dart';
import 'package:time_recorder/theme/colors.dart';
import 'package:time_recorder/ui/common_screens/user_role.dart';
import 'package:time_recorder/ui/employee_screens/employee.dart';
import 'package:time_recorder/ui/supervisor_screens/supervisor.dart';
import 'package:time_recorder/utils/prefs.dart';

class Splash extends StatefulWidget {
  const Splash({Key? key}) : super(key: key);

  @override
  _SplashState createState() => _SplashState();
}

class _SplashState extends State<Splash> {

  @override
  void initState()  {
    doSomeAsyncStuff();

    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: CustomColors.blue_color,
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
           Image.asset(
               "assets/logo.png",
             width: 120,
               height: 120,
           ),
            SizedBox(height: 5,),
            Text(
              "Time Recorder",
              style: TextStyle(
                fontSize: 30,
                color: CustomColors.white_color,
                fontWeight: FontWeight.bold
              ),
            ),
            SizedBox(height: 5,),
            Text(
              "Record the work time",
              style: TextStyle(
                  color: CustomColors.white_color,
              ),
            )
          ],
        ),
      ),
    );
  }

  Future<void> doSomeAsyncStuff() async {
    await Prefs.init();
    YYDialog.init(context);

    SystemChrome.setEnabledSystemUIOverlays([]);

    if(Prefs.getLoginStatus() != null && Prefs.getLoginStatus() == true){
      if(Prefs.getRole() == "1"){
        Navigator.pushReplacement(context, MaterialPageRoute(builder: (context) => Supervisor()));
      }else{
        Navigator.pushReplacement(context, MaterialPageRoute(builder: (context) => Employee()));
      }
    }else{
      Timer(Duration(seconds: 3), ()=>Navigator.pushReplacement(context, MaterialPageRoute(builder: (context) => UserRole())));
    }
  }

}
