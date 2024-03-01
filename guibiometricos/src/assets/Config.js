export var Config = (function () {
    var DeviceKeyIdentifier = "d3andWBdChWyQNLtLAGFMw2B1mKFLROX";
    var xTokenAuthentication="baT5aC9iVd+RQyCstg3T0IIq/LqFmkLQ3GhrSawcn8Jjp2AJOf5CpfCDB5E4VZNj"
        // -------------------------------------
        // REQUIRED
        // The URL to call to process FaceTec SDK Sessions.
        // In Production, you likely will handle network requests elsewhere and without the use of this variable.
        // See https://dev.facetec.com/security-best-practices?link=facetec-server-rest-endpoint-security for more information.
        // NOTE: This field is auto-populated by the FaceTec SDK Configuration Wizard.
        //var BaseURL = "https://docufielxp.fielnet.com.mx/wssvf9_5/";

        var BaseURL = "https://docufielxp.fielnet.com.mx/wssvf9_6/";


        //Buenas tardes Jaime, me comenta que la URL correcta es la siguietne: https://docufielxp.fielnet.com.mx/wssvf9_6/?op=session-token


        // -------------------------------------
        // REQUIRED
        // The FaceScan Encryption Key you define for your application.
        // Please see https://dev.facetec.com/facemap-encryption-keys for more information.
        // NOTE: This field is auto-populated by the FaceTec SDK Configuration Wizard.
        var PublicFaceScanEncryptionKey =
            "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5PxZ3DLj+zP6T6HFgzzk\n" +
            "M77LdzP3fojBoLasw7EfzvLMnJNUlyRb5m8e5QyyJxI+wRjsALHvFgLzGwxM8ehz\n" +
            "DqqBZed+f4w33GgQXFZOS4AOvyPbALgCYoLehigLAbbCNTkeY5RDcmmSI/sbp+s6\n" +
            "mAiAKKvCdIqe17bltZ/rfEoL3gPKEfLXeN549LTj3XBp0hvG4loQ6eC1E1tRzSkf\n" +
            "GJD4GIVvR+j12gXAaftj3ahfYxioBH7F7HQxzmWkwDyn3bqU54eaiB7f0ftsPpWM\n" +
            "ceUaqkL2DZUvgN0efEJjnWy5y1/Gkq5GGWCROI9XG/SwXJ30BbVUehTbVcD70+ZF\n" +
            "8QIDAQAB\n" +
            "-----END PUBLIC KEY-----";


        // -------------------------------------
        // REQUIRED IF: You have had a Production Key generated for you.
        // Production Keys are generated for your account once all steps for Going Production have been completed.
        // More information on Going Production can be found at https://dev.facetec.com/going-production-overview.
        //
        // NOTE:  DO NOT hard code this into your actual App. This variable is coded into the App for demonstration purposes only.
        // Your App MUST serve down the key data via your own API. This allows you to change/update keys without making a client-side change.
        // Please see https://dev.facetec.com/licensing?link=integrating-production-licenses for more information.
        var ProductionKeyText =
            "{  \"domains\": \"\",  \"expiryDate\": \"2024-03-10\",  \"key\": \"003045022046a446e6b8c763e4440ec5c85e6bfd91f6acfdda4a242c5d716895e8fc526126022100938952d8421fa06d2b2a3b3c3aa64061e2bdc6014b4f45aa61bbf944bab58561\"}"


        // -------------------------------------
        // Convenience method to initialize the FaceTec SDK.
        // NOTE: This function is auto-populated by the FaceTec SDK Configuration Wizard based on your UI Customizations you picked in the Configuration Wizard GUI.

        function initializeFromAutogeneratedConfig(FaceTecSDK, callback) {
            FaceTecSDK.initializeInProductionMode(this.ProductionKeyText, this.DeviceKeyIdentifier, this.PublicFaceScanEncryptionKey,
                function (initializedSuccessfully) {
                    FaceTecSDK.configureLocalization(FaceTecStrings);
                    callback(initializedSuccessfully);
                });
        };



    // This app can modify the customization to demonstrate different look/feel preferences
    // NOTE: This function is auto-populated by the FaceTec SDK Configuration Wizard based on your UI Customizations you picked in the Configuration Wizard GUI.
    function retrieveConfigurationWizardCustomization(FaceTecSDK) {
        var defaultCustomization = new FaceTecSDK.FaceTecCustomization();
        this.currentCustomization = defaultCustomization;
        return defaultCustomization;
    };

    var currentCustomization;

    // -------------------------------------
    // Boolean to indicate the FaceTec SDK Configuration Wizard was used to generate this file.
    // In this Sample App, if this variable is true, a "Config Wizard Theme" will be added to this App's Design Showcase,
    // and choosing this option will set the FaceTec SDK UI/UX Customizations to the Customizations that you selected in the
    // Configuration Wizard.
    var wasSDKConfiguredWithConfigWizard = false;

    return {
        wasSDKConfiguredWithConfigWizard,
        DeviceKeyIdentifier,
        BaseURL,
        PublicFaceScanEncryptionKey,
        initializeFromAutogeneratedConfig,
        currentCustomization,
        retrieveConfigurationWizardCustomization,
        xTokenAuthentication,
        ProductionKeyText
    };

})();