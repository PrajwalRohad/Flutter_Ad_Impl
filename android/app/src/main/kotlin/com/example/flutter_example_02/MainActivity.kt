package com.example.flutter_example_02

import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import com.google.android.gms.ads.*
import com.google.android.gms.ads.admanager.AdManagerAdRequest
import com.google.android.gms.ads.admanager.AdManagerAdView
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.google.android.gms.ads.nativead.NativeAdView
import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
//    private val CHANNEL = "com.example.adchannel"
//    private var nativeAd: NativeAd? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        MethodChannel(
//            flutterEngine?.dartExecutor?.binaryMessenger,
//            CHANNEL
//        ).setMethodCallHandler { call, result ->
//            when (call.method) {
//
//                "loadBannerAd" -> {
//                    loadBannerAd()
//                    result.success(null)
//                }
//                "loadInterstitialAd" -> {
//                    loadInterstitialAd()
//                    result.success(null)
//                }
//                "loadRewardedAd" -> {
//                    loadRewardedAd()
//                    result.success(null)
//                }
//                "loadNativeAd" -> {
////                    loadNativeAd()
//                    result.success(null)
//                }
//                else -> {
//                    result.notImplemented()
//                }
//            }
//        }
//    }
//
//
//
//    private fun loadBannerAd() {
//        Log.d("Manan:", "MainActivity Banner clicked...")
//        val adView = AdManagerAdView(this)
//        adView.adUnitId = "ca-app-pub-3940256099942544/2014213617"
//        adView.adSize = AdSize.BANNER
//        adView.adListener = object : AdListener() {
//            override fun onAdLoaded() {
//                Log.d("Manan:", "MainActivity Banner onAdLoaded...")
//            }
//        }
//        val adRequest = AdManagerAdRequest.Builder().build()
//        adView.loadAd(adRequest)
//    }
//
//    private fun loadInterstitialAd() {
//        Log.d("Manan:", "MainActivity Interstitial clicked...")
//        var mAdManagerInterstitialAd: AdManagerInterstitialAd? = null
//        val adRequest = AdManagerAdRequest.Builder().build()
//        AdManagerInterstitialAd.load(
//            this,
//            "/21775744923/example/interstitial",
//            adRequest,
//            object : AdManagerInterstitialAdLoadCallback() {
//                override fun onAdFailedToLoad(adError: LoadAdError) {
//                    mAdManagerInterstitialAd = null
//                }
//
//                override fun onAdLoaded(interstitialAd: AdManagerInterstitialAd) {
//                    mAdManagerInterstitialAd = interstitialAd
//                    interstitialAd.show(this@MainActivity)
//                }
//            }
//        )
//    }
//
//    private fun loadRewardedAd() {
//        Log.d("Manan:", "MainActivity Rewarded clicked...")
//        var rewardedAd: RewardedAd? = null
//        val adRequest = AdManagerAdRequest.Builder().build()
//        RewardedAd.load(
//            this,
//            "/21775744923/example/rewarded",
//            adRequest,
//            object : RewardedAdLoadCallback() {
//                override fun onAdFailedToLoad(adError: LoadAdError) {
//                    rewardedAd = null
//                }
//
//                override fun onAdLoaded(ad: RewardedAd) {
//                    rewardedAd = ad
//                    ad.show(this@MainActivity) { rewardItem ->
//                        val rewardAmount = rewardItem.amount
//                        val rewardType = rewardItem.type
//                    }
//                }
//            }
//        )
//    }

//    private fun loadNativeAd() {
//        Log.d("Manan:", "MainActivity Native clicked...")
//        val adLoader = AdLoader.Builder(this, "/23043175892/Pt9blu/com_gametion_sudokuking/Pt9blu_AND_58_NAT_1_1_1")
//            .forNativeAd { ad: NativeAd ->
//                if (nativeAd != null) {
//                    nativeAd?.destroy()
//                }
//                nativeAd = ad
//                val adView = layoutInflater.inflate(R.layout.ad_unified, null) as NativeAdView
//                populateNativeAdView(ad, adView)
//                val adViewContainer = findViewById<FrameLayout>(R.id.ad_view)
//                adViewContainer.removeAllViews()
//                adViewContainer.addView(adView)
//            }
//            .withNativeAdOptions(NativeAdOptions.Builder().build())
//            .build()
//
//        adLoader.loadAd(AdManagerAdRequest.Builder().build())
//    }
//
//    private fun populateNativeAdView(nativeAd: NativeAd, adView: NativeAdView) {
//        adView.findViewById<TextView>(R.id.ad_headline).text = nativeAd.headline
//        adView.headlineView = adView.findViewById(R.id.ad_headline)
//        nativeAd.body?.let {
//            adView.findViewById<TextView>(R.id.ad_body).text = it
//            adView.bodyView = adView.findViewById(R.id.ad_body)
//        }
//        nativeAd.icon?.let {
//            val iconView = adView.findViewById<ImageView>(R.id.ad_app_icon)
//            iconView.setImageDrawable(it.drawable)
//            adView.iconView = iconView
//        }
//        nativeAd.starRating?.let {
//            val ratingBar = adView.findViewById<RatingBar>(R.id.ad_stars)
//            ratingBar.rating = it.toFloat()
//            ratingBar.visibility = View.VISIBLE
//            adView.starRatingView = ratingBar
//        } ?: run {
//            adView.findViewById<RatingBar>(R.id.ad_stars).visibility = View.GONE
//        }
//        nativeAd.callToAction?.let {
//            val ctaButton = adView.findViewById<Button>(R.id.ad_call_to_action)
//            ctaButton.text = it
//            adView.callToActionView = ctaButton
//        }
//        adView.mediaView = adView.findViewById(R.id.ad_media)
//        adView.setNativeAd(nativeAd)
//    }
}
