 import 'dart:convert';
import 'dart:io';

import 'package:device_info/device_info.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_custom_dialog/flutter_custom_dialog.dart';
 import 'package:image_picker/image_picker.dart';
import 'package:time_recorder/bloc/registration_bloc.dart';
import 'package:time_recorder/theme/colors.dart';
import 'package:time_recorder/utils/global.dart';

import 'login.dart';

class Register extends StatefulWidget {
  const Register({Key? key, required this.roleType}) : super(key: key);

  final int roleType;

  @override
  _RegisterState createState() => _RegisterState();
}

class _RegisterState extends State<Register> {
  late RegistrationBloc _blocRegistration;
  final ImagePicker _picker = ImagePicker();

  late TextEditingController _controllerFirstName;
  late TextEditingController _controllerLastName;
  late TextEditingController _controllerEmail;
  late TextEditingController _controllerPassword;

  String imageString = "";
  File? _image;

  @override
  void initState() {
    _blocRegistration = RegistrationBloc();

    _controllerFirstName = TextEditingController();
    _controllerLastName = TextEditingController();
    _controllerEmail = TextEditingController();
    _controllerPassword = TextEditingController();

    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(8.0),
          child: Center(
            child: Column(
              children: [
                SizedBox(
                  height: 50,
                ),
                Stack(
                  children: [
                    CircleAvatar(
                        maxRadius: 50.0,
                        child: _image != null
                            ? ClipRRect(
                                borderRadius: BorderRadius.circular(50),
                                child: Image.file(
                                  _image!,
                                  width: 100,
                                  height: 100,
                                  fit: BoxFit.fill,
                                ),
                              )
                            : Image.asset("assets/user_logo.png")),
                    Positioned(
                        right: 10,
                        bottom: -2,
                        child: GestureDetector(
                          onTap: () => showDialog(context),
                          child: Icon(Icons.camera),
                        ))
                  ],
                ),
                SizedBox(
                  height: 40,
                ),
                Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text(
                      "First Name",
                      style: TextStyle(
                        fontSize: 20,
                        color: CustomColors.grey_color,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                    StreamBuilder<String>(
                      stream: _blocRegistration.firstName,
                      builder: (context, snapshot) {
                        return TextField(
                            controller: _controllerFirstName,
                            onChanged: (value) {
                              _blocRegistration.setFirstName(value);
                            },
                            decoration: InputDecoration(
                              errorText: snapshot.error == null
                                  ? null
                                  : snapshot.error.toString(),
                              hintText: "First Name",
                            ));
                      },
                    ),
                    SizedBox(
                      height: 40,
                    ),
                    Text(
                      "Last Name",
                      style: TextStyle(
                        fontSize: 20,
                        color: CustomColors.grey_color,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                    StreamBuilder<String>(
                      stream: _blocRegistration.lastName,
                      builder: (context, snapshot) {
                        return TextField(
                            controller: _controllerLastName,
                            onChanged: (value) {
                              _blocRegistration.setLastName(value);
                            },
                            decoration: InputDecoration(
                                errorText: snapshot.error == null
                                    ? null
                                    : snapshot.error.toString(),
                                hintText: "Last Name"));
                      },
                    ),
                    SizedBox(
                      height: 40,
                    ),
                    Text(
                      "Email",
                      style: TextStyle(
                        fontSize: 20,
                        color: CustomColors.grey_color,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                    StreamBuilder<String>(
                      stream: _blocRegistration.email,
                      builder: (context, snapshot) {
                        return TextField(
                            controller: _controllerEmail,
                            onChanged: (value) {
                              _blocRegistration.setEmail(value);
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
                      style: TextStyle(
                        fontSize: 20,
                        color: CustomColors.grey_color,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                    StreamBuilder<String>(
                      stream: _blocRegistration.password,
                      builder: (context, snapshot) {
                        return TextField(
                            controller: _controllerPassword,
                            onChanged: (value) {
                              _blocRegistration.setPassword(value);
                            },
                            decoration: InputDecoration(
                              errorText: snapshot.error == null
                                  ? null
                                  : snapshot.error.toString(),
                              hintText: "Password",
                            ));
                      },
                    ),
                  ],
                ),
                SizedBox(
                  height: 40,
                ),
                SizedBox(
                  width: double.infinity,
                  child: ElevatedButton(
                      onPressed: submitForm, child: Text("Sign Up")),
                ),
                SizedBox(
                  height: 20,
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Text("Already have an account?"),
                    GestureDetector(
                      onTap: () => Navigator.pushReplacement(
                          context,
                          MaterialPageRoute(
                              builder: (context) =>
                                  Login(roleType: widget.roleType))),
                      child: Text(
                        "Login",
                        style: TextStyle(color: CustomColors.blue_color),
                      ),
                    ),
                  ],
                ),
                SizedBox(
                  height: 50,
                )
              ],
            ),
          ),
        ),
      ),
    );
  }

  Future<void> submitForm() async {
    String deviceId = await getDeviceId();
    if (_controllerFirstName.text.isEmpty ||
        _controllerFirstName.text.length == 0) {
      Global.showToast(" First Name can not be empty.");
    } else if (_controllerLastName.text.isEmpty ||
        _controllerLastName.text.length == 0) {
      Global.showToast(" Last Name can not be empty.");
    } else if (_controllerEmail.text.isEmpty ||
        _controllerEmail.text.length == 0 ||
        !_controllerEmail.text.contains('@')) {
      if (_controllerEmail.text.isEmpty || _controllerEmail.text.length == 0) {
        Global.showToast("Email can not be empty.");
      } else {
        Global.showToast("Email is invalid");
      }
    } else if (_controllerPassword.text.isEmpty ||
        _controllerPassword.text.length == 0 ||
        _controllerPassword.text.length < 6) {
      if (_controllerPassword.text.isEmpty ||
          _controllerPassword.text.length == 0) {
        Global.showToast("Password can not be empty.");
      } else {
        Global.showToast("Password Can not be less than 6 character");
      }
    } else if (_image == null && imageString.isEmpty) {
      Global.showToast("Please select your profile image");
    }else if (deviceId == "" ) {
      Global.showToast("can't fetch device Id");
    } else{
        var json = jsonEncode(<String, dynamic>{
         "emailId":_controllerEmail.text.toString(),
         "firstName":_controllerFirstName.text.toString(),
         "lastName":_controllerLastName.text.toString(),
         "password":_controllerPassword.text.toString(),
         "role":widget.roleType,
         "deviceId":deviceId,
         "profileUrl":imageString
        });

        print("println $json");
        _blocRegistration.submitForm(json);
    }
  }



  YYDialog showDialog(BuildContext context) {
    return YYDialog().build(context)
      ..width = 250
      ..height = 120
      ..barrierColor = Colors.black.withOpacity(.3)
      ..animatedFunc = (child, animation) {
        return ScaleTransition(
          child: child,
          scale: Tween(begin: 0.0, end: 1.0).animate(animation),
        );
      }
      ..borderRadius = 10.0
      ..text(
          padding: EdgeInsets.all(10.0),
          color: Colors.black,
          fontSize: 20.0,
          text: "Select Image Either from gallery or camera...")
      ..divider()
      ..doubleButton(
        padding: EdgeInsets.only(top: 10.0),
        gravity: Gravity.center,
        withDivider: true,
        text1: "gallery",
        color1: Colors.redAccent,
        fontSize1: 14.0,
        fontWeight1: FontWeight.bold,
        onTap1: () async {
          final XFile? image =
              await _picker.pickImage(source: ImageSource.gallery);
          var imageBytes = await image!.readAsBytes();
          setState(() {
            _image = File(image.path);
          });
          String imageB64 = base64Encode(imageBytes);
          imageString = "data:image/png;base64,$imageB64";
          print("diffed" + imageB64);
          Global.showToast("gallery selected");
        },
        text2: "Camera",
        color2: Colors.redAccent,
        fontSize2: 14.0,
        fontWeight2: FontWeight.bold,
        onTap2: () async {
          final XFile? photo = await _picker.pickImage(source: ImageSource.camera);
          setState(() {
            _image = File(photo!.path);
          });
          var imageBytes = await photo!.readAsBytes();
          String imageB64 = base64Encode(imageBytes);
          imageString = "data:image/png;base64,$imageB64";
          print("add" + imageB64);
          Global.showToast("Camera selected");
        },
      )
      ..show();
  }

  Future<String> getDeviceId() async {
    try {
      DeviceInfoPlugin deviceInfo = DeviceInfoPlugin();
      AndroidDeviceInfo androidInfo = await deviceInfo.androidInfo;
      print("deictic ${androidInfo.androidId}");
      return androidInfo.androidId.toString();
    } on PlatformException {
      Global.showToast("Error:': 'Failed to get platform version.");
      return "";
    }
  }
}
