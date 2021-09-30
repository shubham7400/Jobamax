import 'package:flutter/material.dart';
import 'package:time_recorder/theme/colors.dart';

class AppCustomTheme {
  static ThemeData get lightTheme {
    //1
    return ThemeData(
        //2
        unselectedWidgetColor: CustomColors.grey_color,
        elevatedButtonTheme: ElevatedButtonThemeData(
            style: ElevatedButton.styleFrom(
                primary: CustomColors.blue_color,
                minimumSize: Size(double.infinity, 40.0),
                textStyle: TextStyle(color: CustomColors.white_color))),

        inputDecorationTheme: InputDecorationTheme(
            focusedBorder: UnderlineInputBorder(
              borderSide: BorderSide(style: BorderStyle.solid, color: CustomColors.blue_color),
            )));
  }
}
