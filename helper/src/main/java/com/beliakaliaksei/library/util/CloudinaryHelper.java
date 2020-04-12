package com.beliakaliaksei.library.util;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryHelper {
    private static final String CLOUD_NAME = "dsnsf4ukx";
    private static final String CLOUD_API_SECRET = "683985465148799";
    private static final String CLOUD_API_KEY = "KGAjN_2wHw_fHaRKbAcp21HCjRs";

    public static Cloudinary getCloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", CLOUD_NAME,
                "api_key", CLOUD_API_KEY,
                "api_secret", CLOUD_API_SECRET));
    }
}
