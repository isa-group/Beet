decl-version 2.0
var-comparability implicit

ppt /search:::CLASS
ppt-type class

ppt /search&search&200():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type search&Input
	rep-type hashcode
variable input.term
	var-kind field term
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.country
	var-kind field country
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.media
	var-kind field media
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.entity
	var-kind field entity
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.attribute
	var-kind field attribute
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type int
	rep-type int
variable input.lang
	var-kind field lang
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.explicit
	var-kind field explicit
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /search&search&200&results():::ENTER
ppt-type enter
variable input
	var-kind variable
	dec-type search&Input
	rep-type hashcode
variable input.term
	var-kind field term
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.country
	var-kind field country
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.media
	var-kind field media
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.entity
	var-kind field entity
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.attribute
	var-kind field attribute
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type int
	rep-type int
variable input.lang
	var-kind field lang
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.explicit
	var-kind field explicit
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String

ppt /search&search&200():::EXIT1
ppt-type subexit
variable input
	var-kind variable
	dec-type search&Input
	rep-type hashcode
variable input.term
	var-kind field term
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.country
	var-kind field country
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.media
	var-kind field media
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.entity
	var-kind field entity
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.attribute
	var-kind field attribute
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type int
	rep-type int
variable input.lang
	var-kind field lang
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.explicit
	var-kind field explicit
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type search&Output&200
	rep-type hashcode
variable return.resultCount
	var-kind field resultCount
	enclosing-var return
	dec-type int
	rep-type int
variable return.results
	var-kind field results
	enclosing-var return
	dec-type results[]
	rep-type hashcode
variable return.results[..]
	var-kind array
	enclosing-var return.results
	array 1
	dec-type results[]
	rep-type hashcode[]

ppt /search&search&200&results():::EXIT2
ppt-type subexit
variable input
	var-kind variable
	dec-type search&Input
	rep-type hashcode
variable input.term
	var-kind field term
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.country
	var-kind field country
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.media
	var-kind field media
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.entity
	var-kind field entity
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.attribute
	var-kind field attribute
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.limit
	var-kind field limit
	enclosing-var input
	dec-type int
	rep-type int
variable input.lang
	var-kind field lang
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable input.explicit
	var-kind field explicit
	enclosing-var input
	dec-type java.lang.String
	rep-type java.lang.String
variable return
	var-kind return
	dec-type search&Output&200&results
	rep-type hashcode
variable return.wrapperType
	var-kind field wrapperType
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.explicitness
	var-kind field explicitness
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.kind
	var-kind field kind
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.trackName
	var-kind field trackName
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.artistName
	var-kind field artistName
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.collectionName
	var-kind field collectionName
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.censoredName
	var-kind field censoredName
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.artworkUrl100
	var-kind field artworkUrl100
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.artworkUrl60
	var-kind field artworkUrl60
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.viewUrl
	var-kind field viewUrl
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.previewUrl
	var-kind field previewUrl
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.trackTimeMillis
	var-kind field trackTimeMillis
	enclosing-var return
	dec-type int
	rep-type int
variable return.artistId
	var-kind field artistId
	enclosing-var return
	dec-type int
	rep-type int
variable return.collectionId
	var-kind field collectionId
	enclosing-var return
	dec-type int
	rep-type int
variable return.trackId
	var-kind field trackId
	enclosing-var return
	dec-type int
	rep-type int
variable return.collectionCensoredName
	var-kind field collectionCensoredName
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.trackCensoredName
	var-kind field trackCensoredName
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.artistViewUrl
	var-kind field artistViewUrl
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.collectionViewUrl
	var-kind field collectionViewUrl
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.trackViewUrl
	var-kind field trackViewUrl
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.collectionPrice
	var-kind field collectionPrice
	enclosing-var return
	dec-type double
	rep-type double
variable return.trackPrice
	var-kind field trackPrice
	enclosing-var return
	dec-type double
	rep-type double
variable return.collectionExplicitness
	var-kind field collectionExplicitness
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.trackExplicitness
	var-kind field trackExplicitness
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.discCount
	var-kind field discCount
	enclosing-var return
	dec-type int
	rep-type int
variable return.discNumber
	var-kind field discNumber
	enclosing-var return
	dec-type int
	rep-type int
variable return.trackCount
	var-kind field trackCount
	enclosing-var return
	dec-type int
	rep-type int
variable return.trackNumber
	var-kind field trackNumber
	enclosing-var return
	dec-type int
	rep-type int
variable return.country
	var-kind field country
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.currency
	var-kind field currency
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.primaryGenreName
	var-kind field primaryGenreName
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.description
	var-kind field description
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.amgArtistId
	var-kind field amgArtistId
	enclosing-var return
	dec-type int
	rep-type int
variable return.copyright
	var-kind field copyright
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.releaseDate
	var-kind field releaseDate
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.artworkUrl30
	var-kind field artworkUrl30
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.artworkUrl600
	var-kind field artworkUrl600
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.collectionHdPrice
	var-kind field collectionHdPrice
	enclosing-var return
	dec-type double
	rep-type double
variable return.contentAdvisoryRating
	var-kind field contentAdvisoryRating
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.feedUrl
	var-kind field feedUrl
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.genreIds
	var-kind field genreIds
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.genreIds[..]
	var-kind array
	enclosing-var return.genreIds
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.genres
	var-kind field genres
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.genres[..]
	var-kind array
	enclosing-var return.genres
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.collectionArtistId
	var-kind field collectionArtistId
	enclosing-var return
	dec-type int
	rep-type int
variable return.collectionArtistName
	var-kind field collectionArtistName
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.isStreamable
	var-kind field isStreamable
	enclosing-var return
	dec-type boolean
	rep-type boolean
variable return.longDescription
	var-kind field longDescription
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.shortDescription
	var-kind field shortDescription
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.trackHdPrice
	var-kind field trackHdPrice
	enclosing-var return
	dec-type double
	rep-type double
variable return.trackHdRentalPrice
	var-kind field trackHdRentalPrice
	enclosing-var return
	dec-type double
	rep-type double
variable return.trackRentalPrice
	var-kind field trackRentalPrice
	enclosing-var return
	dec-type double
	rep-type double
variable return.collectionArtistViewUrl
	var-kind field collectionArtistViewUrl
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.hasITunesExtras
	var-kind field hasITunesExtras
	enclosing-var return
	dec-type boolean
	rep-type boolean
variable return.advisories
	var-kind field advisories
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.advisories[..]
	var-kind array
	enclosing-var return.advisories
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.appletvScreenshotUrls
	var-kind field appletvScreenshotUrls
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.appletvScreenshotUrls[..]
	var-kind array
	enclosing-var return.appletvScreenshotUrls
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.artworkUrl512
	var-kind field artworkUrl512
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.averageUserRating
	var-kind field averageUserRating
	enclosing-var return
	dec-type double
	rep-type double
variable return.averageUserRatingForCurrentVersion
	var-kind field averageUserRatingForCurrentVersion
	enclosing-var return
	dec-type double
	rep-type double
variable return.userRatingCountForCurrentVersion
	var-kind field userRatingCountForCurrentVersion
	enclosing-var return
	dec-type int
	rep-type int
variable return.bundleId
	var-kind field bundleId
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.currentVersionReleaseDate
	var-kind field currentVersionReleaseDate
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.features
	var-kind field features
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.features[..]
	var-kind array
	enclosing-var return.features
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.fileSizeBytes
	var-kind field fileSizeBytes
	enclosing-var return
	dec-type int
	rep-type int
variable return.formattedPrice
	var-kind field formattedPrice
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.ipadScreenshotUrls
	var-kind field ipadScreenshotUrls
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.ipadScreenshotUrls[..]
	var-kind array
	enclosing-var return.ipadScreenshotUrls
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.isGameCenterEnabled
	var-kind field isGameCenterEnabled
	enclosing-var return
	dec-type boolean
	rep-type boolean
variable return.isVppDeviceBasedLicensingEnabled
	var-kind field isVppDeviceBasedLicensingEnabled
	enclosing-var return
	dec-type boolean
	rep-type boolean
variable return.languageCodesISO2A
	var-kind field languageCodesISO2A
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.languageCodesISO2A[..]
	var-kind array
	enclosing-var return.languageCodesISO2A
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.minimumOsVersion
	var-kind field minimumOsVersion
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.price
	var-kind field price
	enclosing-var return
	dec-type double
	rep-type double
variable return.primaryGenreId
	var-kind field primaryGenreId
	enclosing-var return
	dec-type int
	rep-type int
variable return.releaseNotes
	var-kind field releaseNotes
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.screenshotUrls
	var-kind field screenshotUrls
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.screenshotUrls[..]
	var-kind array
	enclosing-var return.screenshotUrls
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.sellerName
	var-kind field sellerName
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.sellerUrl
	var-kind field sellerUrl
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.supportedDevices
	var-kind field supportedDevices
	enclosing-var return
	dec-type java.lang.String[]
	rep-type hashcode
variable return.supportedDevices[..]
	var-kind array
	enclosing-var return.supportedDevices
	array 1
	dec-type java.lang.String[]
	rep-type java.lang.String[]
variable return.trackContentRating
	var-kind field trackContentRating
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.userRatingCount
	var-kind field userRatingCount
	enclosing-var return
	dec-type int
	rep-type int
variable return.version
	var-kind field version
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.artistIds
	var-kind field artistIds
	enclosing-var return
	dec-type int[]
	rep-type hashcode
variable return.artistIds[..]
	var-kind array
	enclosing-var return.artistIds
	array 1
	dec-type int[]
	rep-type int[]
variable return.artistLinkUrl
	var-kind field artistLinkUrl
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.artistType
	var-kind field artistType
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.collectionType
	var-kind field collectionType
	enclosing-var return
	dec-type java.lang.String
	rep-type java.lang.String
variable return.amgVideoArtistId
	var-kind field amgVideoArtistId
	enclosing-var return
	dec-type int
	rep-type int

