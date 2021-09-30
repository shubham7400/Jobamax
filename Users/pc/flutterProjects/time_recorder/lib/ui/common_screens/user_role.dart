import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:time_recorder/theme/colors.dart';

import 'login.dart';

class UserRole extends StatelessWidget {
  const UserRole({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body:  Center(
          child: SingleChildScrollView(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(
                  "I AM",
                  style: TextStyle(
                    fontSize: 30,
                    color: CustomColors.blue_font_color,
                    fontWeight: FontWeight.bold
                  ),
                ),
                SizedBox(height: 40,),
                GestureDetector(
                  onTap: () => Navigator.pushReplacement(context, MaterialPageRoute(builder: (context) => Login(roleType: 2))),
                  child: Image.asset(
                      "assets/employee_logo.png",
                    width: 120,
                      height: 120,
                  ),
                ),
                SizedBox(height: 10,),
                Text(
                  "Employee",
                  style: TextStyle(
                      fontSize: 20,
                      fontWeight: FontWeight.bold
                  ),
                ),
                SizedBox(height: 40,),
                GestureDetector(
                    onTap: () => Navigator.pushReplacement(context, MaterialPageRoute(builder: (context) => Login(roleType: 1))),
                    child: Image.asset(
                        "assets/supervisor_logo.png",
                      width: 120,
                      height: 120,
                    )
                ),
                SizedBox(height: 10,),
                Text(
                  "Supervisor",
                  style: TextStyle(
                      fontSize: 20,
                      fontWeight: FontWeight.bold
                  ),
                ),
              ],
            ),
          )
      ),
    );
  }
}
