import 'package:flutter/material.dart';
import 'package:time_recorder/theme/app_custom_theme.dart';
import 'package:time_recorder/ui/common_screens/splash.dart';

void main() => runApp(MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Splash(),
  theme: AppCustomTheme.lightTheme,
    ));
