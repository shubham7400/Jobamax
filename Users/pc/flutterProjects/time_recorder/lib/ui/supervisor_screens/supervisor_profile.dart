import 'dart:convert';
import 'dart:io';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_custom_dialog/flutter_custom_dialog.dart';
import 'package:image_picker/image_picker.dart';
import 'package:time_recorder/bloc/supervisor_bloc.dart';
import 'package:time_recorder/data_layer/User.dart';
import 'package:time_recorder/theme/colors.dart';
import 'package:time_recorder/ui/common_screens/user_role.dart';
import 'package:time_recorder/utils/global.dart';
import 'package:time_recorder/utils/prefs.dart';

class SupervisorProfile extends StatefulWidget {
  const SupervisorProfile({Key? key}) : super(key: key);

  @override
  _SupervisorProfileState createState() => _SupervisorProfileState();
}

class _SupervisorProfileState extends State<SupervisorProfile> {
  late SupervisorBloc _blocSupervisor;

  late TextEditingController _controllerFirstName;
  late TextEditingController _controllerLastName;
  late TextEditingController _controllerEmail;

  final ImagePicker _picker = ImagePicker();
  String imageString = "";
  File? _image;

  @override
  void initState() {
    _blocSupervisor = SupervisorBloc();

    _controllerFirstName = TextEditingController();
    _controllerLastName = TextEditingController();
    _controllerEmail = TextEditingController();

    getInitialWorkDone();
    initializeProfile();

    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Column(
          children: [
            Material(
              elevation: 3,
              child: Container(
                alignment: Alignment.center,
                width: double.infinity,
                height: 50,
                child: Text(
                  "PROFILE",
                  style: TextStyle(
                    color: CustomColors.blue_font_color,
                    fontWeight: FontWeight.bold,
                    fontSize: 25,
                  ),
                ),
              ),
            ),
            SizedBox(
              height: 40,
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
                        : ClipRRect(
                            borderRadius: BorderRadius.circular(50),
                            child: Image.network(
                              Prefs.getProfileImageUrl()!,
                              fit: BoxFit.fill,
                              width: 100,
                              height: 100,
                            ),
                          )),
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
            Padding(
              padding: const EdgeInsets.all(15),
              child: Row(
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Image.asset(
                    "assets/user.png",
                  ),
                  SizedBox(
                    width: 10,
                  ),
                  Flexible(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          "First Name",
                          style: TextStyle(
                              fontSize: 20,
                              color: CustomColors.grey_color,
                              fontWeight: FontWeight.bold),
                        ),
                        TextField(
                          controller: _controllerFirstName,
                        ),
                        SizedBox(
                          height: 40,
                        ),
                        Text(
                          "Last Name",
                          style: TextStyle(
                              fontSize: 20,
                              color: CustomColors.grey_color,
                              fontWeight: FontWeight.bold),
                        ),
                        TextField(
                          controller: _controllerLastName,
                        ),
                      ],
                    ),
                  )
                ],
              ),
            ),
            SizedBox(
              height: 10,
            ),
            Padding(
              padding: const EdgeInsets.all(15.0),
              child: Row(
                children: [
                  Image.asset(
                    "assets/mail.png",
                  ),
                  SizedBox(
                    width: 10,
                  ),
                  Flexible(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          "Email",
                          style: TextStyle(
                              fontSize: 20,
                              color: CustomColors.grey_color,
                              fontWeight: FontWeight.bold),
                        ),
                        TextField(
                          enabled: false,
                          controller: _controllerEmail,
                        ),
                      ],
                    ),
                  )
                ],
              ),
            ),
            SizedBox(
              height: 50,
            ),
            Padding(
              padding: const EdgeInsets.fromLTRB(30, 0, 30, 0),
              child: StreamBuilder<User>(
                  stream: _blocSupervisor.user,
                  builder: (context, snapshot) {
                    final user = snapshot.data;
                    if (user != null) {
                      if (user.isLogin) {
                        Prefs.setFirstName(user.firstName);
                        Prefs.setLastName(user.lastName);
                        Prefs.setProfileImageUrl(user.profileUrl);
                      }
                    }

                    return ElevatedButton(
                      onPressed: updateUserProfile,
                      child: Text("Update"),
                    );
                  }),
            ),
            SizedBox(
              height: 10,
            ),
            Padding(
              padding: const EdgeInsets.fromLTRB(30, 0, 30, 0),
              child: ElevatedButton(
                onPressed: logout,
                child: Text(
                  "Logout",
                  style: TextStyle(color: CustomColors.blue_color),
                ),
                style: ElevatedButton.styleFrom(
                  primary: Colors.white,
                  side: BorderSide(width: 2, color: CustomColors.blue_color),
                ),
              ),
            )
          ],
        ),
      ),
    );
  }

  YYDialog showDialog(BuildContext context) {
    return YYDialog().build(context)
      ..width = 300
      ..backgroundColor = CustomColors.white_color
      ..barrierColor = Colors.black.withOpacity(.6)
      ..animatedFunc = (child, animation) {
        return ScaleTransition(
          child: child,
          scale: Tween(begin: 0.0, end: 1.0).animate(animation),
        );
      }
      ..borderRadius = 10.0
      ..text(
          textAlign: TextAlign.center,
          padding: EdgeInsets.fromLTRB(10, 20, 10, 20),
          color: CustomColors.black_font_color,
          fontSize: 20.0,
          text: "Select Image Either from gallery or camera...")
      ..divider()
      ..doubleButton(
        gravity: Gravity.spaceEvenly,
        padding: EdgeInsets.only(top: 10.0),
        withDivider: true,
        text1: "gallery",
        color1: CustomColors.blue_font_color,
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
        color2: CustomColors.blue_font_color,
        fontSize2: 14.0,
        fontWeight2: FontWeight.bold,
        onTap2: () async {
          final XFile? photo =
              await _picker.pickImage(source: ImageSource.camera);
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

  Future<void> getInitialWorkDone() async {
    await Prefs.init();
  }

  void initializeProfile() {
    _controllerFirstName.text = Prefs.getFirstName()!;
    _controllerLastName.text = Prefs.getLastName()!;
    _controllerEmail.text = Prefs.getEmail()!;
  }

  void updateUserProfile() {
    if (_controllerFirstName.text.isEmpty ||
        _controllerFirstName.text.length == 0) {
      Global.showToast(" First Name can not be empty.");
    } else if (_controllerLastName.text.isEmpty ||
        _controllerLastName.text.length == 0) {
      Global.showToast(" Last Name can not be empty.");
    } else {
      var jsonBody = jsonEncode(<String, dynamic>{
        "firstName": _controllerFirstName.text.toString(),
        "lastName": _controllerLastName.text.toString(),
        "profileUrl": imageString
      });

      print("println $json");
      _blocSupervisor.updateUser(jsonBody, Prefs.getToken()!);
    }
  }

  void logout() {
    Prefs.setLoginStatus(false);
    Prefs.setToken("");
    Prefs.setEmail("");
    Prefs.setRole("");
    Prefs.setFirstName("");
    Prefs.setLastName("");
    Prefs.setUserId("");
    Prefs.setProfileImageUrl("");

    Navigator.of(context, rootNavigator: true).pushReplacement(
        MaterialPageRoute(builder: (context) => new UserRole()));
  }
}
