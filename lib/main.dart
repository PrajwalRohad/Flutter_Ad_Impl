import 'package:flutter/material.dart';
import 'package:google_mobile_ads/google_mobile_ads.dart';
import 'package:logger/logger.dart';
import 'package:talker/talker.dart';


var logger = Logger(
  printer: PrettyPrinter(),
);

var loggerNoStack = Logger(
  printer: PrettyPrinter(methodCount: 0),
);
void main() {
  WidgetsFlutterBinding.ensureInitialized();
  MobileAds.instance.initialize();

  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Ad Integration',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(),
    );
  }
}

class _MyHomePageState extends State<MyHomePage> {
  BannerAd? bannerAd;
  InterstitialAd? interstitialAd;

  // Initialize banner ad
  void loadBannerAd() {
    bannerAd?.dispose(); // Remove old banner ad if exists
    bannerAd = BannerAd(
      size: AdSize.banner,
      adUnitId: "/23043175892/PGh622/tech_crackle_financecalculator/PGh622_AND_7_BAN_50_320_2",
      listener: BannerAdListener(
        onAdLoaded: (ad) {
          print("Manan: MainActivity Banner onAdLoaded...");
          logger.d("Manan: MainActivity Banner onAdLoaded...");
        },
        onAdFailedToLoad: (ad, error) {
          print("Manan: MainActivity Banner onAdFailedToLoad...$error");
          logger.d("Manan: MainActivity Banner onAdFailedToLoad...$error");
          ad.dispose();
        },
      ),
      request: const AdRequest(),
    );
    bannerAd!.load();
  }

  // Initialize interstitial ad
  void loadInterstitialAd() {
    InterstitialAd.load(
      adUnitId: "/23043175892/PGh622/PGh622_AND_7_INT_9999_9999_2",
      request: const AdRequest(),
      adLoadCallback: InterstitialAdLoadCallback(
        onAdLoaded: (InterstitialAd ad) {
          interstitialAd = ad;
          print("Manan: Interstitial ad loaded.");
          interstitialAd!.show();
          interstitialAd!.fullScreenContentCallback = FullScreenContentCallback(
            onAdDismissedFullScreenContent: (ad) {
              print("Manan: Interstitial ad dismissed.");
              ad.dispose();
            },
            onAdFailedToShowFullScreenContent: (ad, error) {
              print("Manan: Interstitial ad failed to show...$error");
              ad.dispose();
            },
          );
        },
        onAdFailedToLoad: (LoadAdError error) {
          print("Manan: Failed to load interstitial ad...$error");
        },
      ),
    );
  }

  @override
  void dispose() {
    bannerAd?.dispose();
    interstitialAd?.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Ad Integration")),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            ElevatedButton(
              onPressed: () {
                loadBannerAd();
                setState(() {}); // Rebuild to display new banner ad
              },
              child: const Text("Load Banner Ad"),
            ),
            ElevatedButton(
              onPressed: () {
                loadInterstitialAd();
              },
              child: const Text("Load Interstitial Ad"),
            ),
          ],
        ),
      ),
      bottomNavigationBar: bannerAd != null
          ? Container(
        child: AdWidget(ad: bannerAd!),
        key: UniqueKey(),
        height: 100,
      )
          : const SizedBox.shrink(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}
