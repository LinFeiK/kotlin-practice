enum class Country {
    CANADA, FRANCE, NEW_ZEALAND, USA
}

enum class CountryWithCode(val code: String) {
    AUSTRALIA("AU"),
    GERMANY("DE"),
    NIGERIA("NG")
}