package com.pokescanner.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.pokescanner.R;
import com.pokescanner.helper.Settings;


public class SettingsUtil {

    public static final String ENABLE_UPDATES = "updatesEnabled";
    public static final String KEY_BOUNDING_BOX = "boundingBoxEnabled";
    public static final String SHOW_ONLY_LURED = "showOnlyLured";
    public static final String SHOW_GYMS = "showGyms";
    public static final String SHOW_POKESTOPS = "showPokestops";
    public static final String SHOW_LURED_POKEMON = "showLuredPokemon";
    public static final String KEY_LOCK_GPS = "lockGpsEnabled";

    public static final String SERVER_REFRESH_RATE = "serverRefreshRate";
    public static final String MAP_REFRESH_RATE = "mapRefreshRate";
    public static final String POKEMON_ICON_SCALE = "pokemonIconScale";
    public static final String SCAN_VALUE = "scanValue";

    public static final String LAST_USERNAME = "lastUsername";

    public static final String SHUFFLE_ICONS = "shuffleIcons";

    public static Settings getSettings(Context context) {
        SharedPreferences sharedPrefs = context.getSharedPreferences(
            context.getString(R.string.shared_key),
            Context.MODE_PRIVATE
        );
        return new Settings(
            sharedPrefs.getBoolean(ENABLE_UPDATES,true),
            sharedPrefs.getBoolean(KEY_BOUNDING_BOX, false),
            sharedPrefs.getBoolean(KEY_LOCK_GPS, false),
            sharedPrefs.getInt(SCAN_VALUE, 4),
            sharedPrefs.getInt(SERVER_REFRESH_RATE, 1),
            sharedPrefs.getInt(POKEMON_ICON_SCALE, 2),
            sharedPrefs.getInt(MAP_REFRESH_RATE, 2),
            sharedPrefs.getString(LAST_USERNAME, ""),
            sharedPrefs.getBoolean(SHOW_ONLY_LURED, false),
            sharedPrefs.getBoolean(SHOW_GYMS, true),
            sharedPrefs.getBoolean(SHOW_POKESTOPS, true),
                sharedPrefs.getBoolean(SHOW_LURED_POKEMON, true),
                sharedPrefs.getBoolean(SHUFFLE_ICONS, false)
        );
    }

    public static void saveSettings(Context context, Settings settings) {
        context.getSharedPreferences(context.getString(R.string.shared_key), Context.MODE_PRIVATE)
            .edit()
            .putBoolean(ENABLE_UPDATES,settings.isUpdatesEnabled())
            .putBoolean(KEY_BOUNDING_BOX, settings.isBoundingBoxEnabled())
            .putBoolean(KEY_LOCK_GPS, settings.isLockGpsEnabled())
            .putInt(SCAN_VALUE,settings.getScanValue())
            .putInt(SERVER_REFRESH_RATE, settings.getServerRefresh())
            .putInt(MAP_REFRESH_RATE, settings.getMapRefresh())
            .putInt(POKEMON_ICON_SCALE, settings.getScale())
            .putString(LAST_USERNAME, settings.getLastUsername())
            .putBoolean(SHOW_ONLY_LURED, settings.isShowOnlyLured())
            .putBoolean(SHOW_GYMS, settings.isGymsEnabled())
            .putBoolean(SHOW_POKESTOPS, settings.isPokestopsEnabled())
                .putBoolean(SHOW_LURED_POKEMON, settings.isShowLuredPokemon())
                .putBoolean(SHUFFLE_ICONS, settings.isShuffleIcons())
            .apply();
    }
}