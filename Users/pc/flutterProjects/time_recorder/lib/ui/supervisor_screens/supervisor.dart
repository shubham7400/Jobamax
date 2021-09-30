import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:persistent_bottom_nav_bar/persistent-tab-view.dart';
import 'package:time_recorder/theme/colors.dart';
import 'package:time_recorder/ui/supervisor_screens/supervisor_home.dart';
import 'package:time_recorder/ui/supervisor_screens/supervisor_profile.dart';
import 'package:time_recorder/ui/supervisor_screens/supervisor_task.dart';

class Supervisor extends StatefulWidget {
  const Supervisor({  Key? key}) : super(key: key);

  @override
  _SupervisorState createState() => _SupervisorState();
}

class _SupervisorState extends State<Supervisor> {
  late PersistentTabController _controller;

  @override
  void initState() {

    _controller = PersistentTabController(initialIndex: 0);
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return PersistentTabView(
      context,
      controller: _controller,
      screens: _buildScreens(),
      items: _navBarsItems(),
      confineInSafeArea: true,
      backgroundColor: Colors.white, // Default is Colors.white.
      handleAndroidBackButtonPress: true, // Default is true.
      resizeToAvoidBottomInset: true, // This needs to be true if you want to move up the screen when keyboard appears. Default is true.
      stateManagement: true, // Default is true.
      hideNavigationBarWhenKeyboardShows: true, // Recommended to set 'resizeToAvoidBottomInset' as true while using this argument. Default is true.
      decoration: NavBarDecoration(
        borderRadius: BorderRadius.circular(10.0),
        colorBehindNavBar: Colors.white,
      ),
      popAllScreensOnTapOfSelectedTab: true,
      popActionScreens: PopActionScreensType.all,
      itemAnimationProperties: ItemAnimationProperties( // Navigation Bar's items animation properties.
        duration: Duration(milliseconds: 200),
        curve: Curves.ease,
      ),
      screenTransitionAnimation: ScreenTransitionAnimation( // Screen transition animation on change of selected tab.
        animateTabTransition: true,
        curve: Curves.ease,
        duration: Duration(milliseconds: 200),
      ),
      navBarStyle: NavBarStyle.style6, // Choose the nav bar style with this property.
    );
  }

  List<Widget> _buildScreens() {
    return [
      SupervisorHome(),
      SupervisorTask(),
      SupervisorProfile()
    ];
  }

  List<PersistentBottomNavBarItem> _navBarsItems() {
    return [
      PersistentBottomNavBarItem(
        icon: Icon(Icons.home),
        title: ("Home"),
        activeColorPrimary: CustomColors.blue_color,
        inactiveColorPrimary: CustomColors.grey_color,
      ),
      PersistentBottomNavBarItem(
        icon: Icon(Icons.task),
        title: ("Tasks"),
        activeColorPrimary: CustomColors.blue_color,
        inactiveColorPrimary: CustomColors.grey_color,
      ),
      PersistentBottomNavBarItem(
        icon: Icon(Icons.supervised_user_circle_rounded),
        title: ("Profile"),
        activeColorPrimary: CustomColors.blue_color,
        inactiveColorPrimary: CustomColors.grey_color,
      ),
    ];
  }

}


class SettingsScreen extends StatefulWidget {
  const SettingsScreen({Key? key}) : super(key: key);

  @override
  _SettingsScreenState createState() => _SettingsScreenState();
}

class _SettingsScreenState extends State<SettingsScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Setting Screen"),
      ),
    );
  }
}



class MainScreen extends StatefulWidget {
  const MainScreen({Key? key}) : super(key: key);

  @override
  _MainScreenState createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Main Screen"),
      ),
      body: Container(
        child: ElevatedButton(
          onPressed: () {
            pushNewScreen(
              context,
              screen: MainScreen(),
              withNavBar: true, // OPTIONAL VALUE. True by default.
              pageTransitionAnimation: PageTransitionAnimation.cupertino,
            );
          }, child: (Text("1111111111111")),

        ),
      ),
    );
  }

}
