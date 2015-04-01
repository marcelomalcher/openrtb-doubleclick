Google DoubleClick Libraries
----------------------------------------------------------------------

This library supports RTB development for DoubleClick Ad Exchange
in Java. The doubleclick-core module includes DoubleClick's RTB model
and associated facilities such as crypto and metadata.  The second
module, doubleclick-openrtb, provides client-side mapping between
DoubleClick's model/protocol and OpenRTB, and validation support.

See our [wiki](https://github.com/google/openrtb-doubleclick/wiki)
to get started!
Use the Github issue tracker for bugs, RFEs or any support.


BUILDING NOTES
----------------------------------------------------------------------

You need: JDK 7, Maven 3.2, Protocol buffers (protoc) 2.6.1.
Building is supported from the command line with Maven and
from any IDE that can load Maven projects.

On Eclipse, the latest m2e is recommended but it can't run the code
generation step, so you need to run a "mvn install" from the command
line after checkout or after any mvn clean.


RELEASE NOTES
----------------------------------------------------------------------

## Version 0.8.0-beta3, 31-03-2015

* Logging updates, mostly avoiding multiline logs (bad for syslog).
* Refactor some DoubleClickMetadata helper types.

## Version 0.8.0-beta2, 13-03-2015

* BidRequest.id & User.customdata using base64Url, not base16.
* Fix bcat mapping; optimize some enum mappings.
* More metadata: Agencies, Site lists, Creative status.
* Removed error-prone from build, new version had some issues too.

## Version 0.8.0-beta, 20-02-2015

* Support for Native Ads completed!
* Maps `Publisher.name`.
* `ExtMapper` has new methods that make easier to create mapper
  extensions for the objects: `App`, `Site`, `User`.
* DoubleClick protocol v.59, adds `mediation_status`.
* Updated to latest error-prone; now Maven build works with JDK 8!

## Version 0.7.5, 02-12-2014

* Partial support for OpenRTB 2.3! The missing item is Native ads,
  which depends on the OpenRTB Native 1.0 spec (proposed final draft
  at this time). This support will come in a future update.
  (Meanwhile you can bid on native ads with DoubleClick's protocol.)
  - Maps OpenRTB `Bid.cat` / DC `Ad.category`
  - Maps DC `BidRequest.isTest` / OpenRTB `BidRequest.test`
  - Maps DC `Mobile.[constrainedUsage]encryptedAdvertisingId`
    / OpenRTB `Device.ifa`; also, sets OpenRTB `Device.lmt`
  - Maps DC `Mobile.screenWidth/screenHeight` / OpenRTB `Device.w/h`
  - Maps DC `Mobile.devicePixelRatioMillis` / OpenRTB `Device.pxratio`
  - Maps DC `BidRequest.timezoneOffset` / OpenRTB `Geo.utcoffset`
  - Maps DC `Mobile.mobileWebOptimized` / OpenRTB `Site.mobile`
* Fix `BidResponse` mapping, was broken for non-multisize, interstitial
  video impression (DoubleClick requires setting `width/height`).
* Improvements and cleanups in the internal CSV parser.

## Version 0.7.4, 21-11-2014

* DoubleClick proto v57.  Notice that the major new in this update is
  native ads, but the corresponding OpenRTB spec is not finalized so
  there's no DoubleClick/OpenRTB mapping support at this time.
  - Maps DC `IFramingState` / OpenRTB `topframe`.
  - Maps OpenRTB `Bid.nurl` / DC `Ad.impressionTrackingUrl`

## Version 0.7.3, 17-11-2014

* Fix mapping of `BidRequest.User.customdata`.

## Version 0.7.2, 29-10-2014

* Updated to Protocol Buffers 2.6.1 (bugfix, doesn't require rebuilds).
* `DoubleClickMetadata` more resilient to bad resources.
* DoubleClick protocol v.54.
* Test & logging reviews.

## Version 0.7.1, 20-10-2014

* Updated to Protocol Buffers 2.6.0. Full rebuild recommended, the
  code generated by protoc 2.6.0 is NOT 100% compatible with 2.5.0.

## Version 0.7.0, 16-10-2014

* Fix namespace of DoubleClick proto to Google standard: replace all
  `com.google.doubleclick.Doubleclick`->`com.google.protos.adx.NetworkBid`.
* `DoubleClickValidator` validates SSL-enabled ads.

## Version 0.6.6, 14-10-2014

* DoubleClick proto v.52.
* Mapper: Much better mapping of IAB categories.
* New link extension `DcExt.bidResponse`.
* Javadocs for thead safety.
* Update Guava library.

## Version 0.6.5, 18-08-2014

- Crypto reviews: `javax.security`'s exceptions; initVector improvements;
  fix block cypher for >1 blocks; `Price` method names (millis/micros).
- Metadata: content-labels, publisher-verticals; better GeoTable parser.
- Mapper: Fix `AdPosition` & `Banner.mimes`; add `Content.contentrating`,
  `User.data.segment`, `Banner.expdir`, `Video.startdelay` (special values).
- DoubleClickValidator: validates `deal_id`; optimizations.

## Version 0.6.4, 10-08-2014

* Remove dependency from apache-commons-codec!
* `DoubleClickValidator` improved (better logs) and refactored to not
  depend on OpenRTB; moved to the doubleclick-core module.
* Provide a `DoubleClickMetadata.URLConnectionTransport`.
* Added missing two methods in the mapper interface.
* `DoubleClickCrypto.Price` supports micros & currency unit.
* No need anymore to checkout the openrtb project for building.

## Version 0.6.3, 02-08-2014

* Update DoubleClick protocol to v51.
* Map `User.gender/age` from new `UserDemographics` data.
* Decrypt `HyperlocalSet`, keep in a link extension, and map `Geo.lat/lon`.
* Map `Video.mimes` and `Video.companionad.mimes`.
* `DoubleClickCrypto`: IDFA/Hyperlocal now correct; big general review.
* Fixed mapping of `price` and `bidfloor` properties to use currency units
  (which is the standard). Previous code used micros, that was a legacy
  from this code's DoubleClick roots but was not OpenRTB-compliant.

## Version 0.6.2, 25-07-2014

* `DoubleClickCrypto`: optimize memory usage in Base64 encoding/decoding;
  some initial fixes for IDFA/Hyperlocal but still broken in some cases.
* Remove dependency on buggy, unsupported opencsv; using custom parser.
* Mapping: Fix semi-transparent branded channels.

## Version 0.6.1, 15-07-2014

* Remove depedency from Guice! The libraries still supports all
  JSR-305 DI frameworks, but now only uses `javax.inject`.
* DoubleClick protocol v50; map `app.content.userrating`, `app.name`.
* Build system improvements (Maven, Eclipse, NetBeans).
* Improved `OpenRtbSnippetProcessor` handling of macro dependencies;
  see new documentation about this in `OpenRtbMacros`.

## Version 0.6, 10-07-2014

* Initial Open Source release.
