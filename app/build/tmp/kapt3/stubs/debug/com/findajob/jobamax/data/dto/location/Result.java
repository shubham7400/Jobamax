package com.findajob.jobamax.data.dto.location;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0018J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0006H\u00c6\u0003J\t\u0010/\u001a\u00020\u0006H\u00c6\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0006H\u00c6\u0003J\t\u00102\u001a\u00020\u0015H\u00c6\u0003J\t\u00103\u001a\u00020\u0006H\u00c6\u0003J\t\u00104\u001a\u00020\u0006H\u00c6\u0003J\t\u00105\u001a\u00020\u0006H\u00c6\u0003J\t\u00106\u001a\u00020\u0006H\u00c6\u0003J\t\u00107\u001a\u00020\tH\u00c6\u0003J\t\u00108\u001a\u00020\u0006H\u00c6\u0003J\t\u00109\u001a\u00020\u0006H\u00c6\u0003J\t\u0010:\u001a\u00020\u0006H\u00c6\u0003J\t\u0010;\u001a\u00020\u0006H\u00c6\u0003J\u000f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H\u00c6\u0003J\u00bb\u0001\u0010=\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010A\u001a\u00020\u0015H\u00d6\u0001J\t\u0010B\u001a\u00020\u0006H\u00d6\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0016\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0016\u0010\u0010\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0016\u0010\u0011\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001aR\u0016\u0010\u0013\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\u0016\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0016\u0010\u0017\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001c\u00a8\u0006C"}, d2 = {"Lcom/findajob/jobamax/data/dto/location/Result;", "", "addressComponents", "", "Lcom/findajob/jobamax/data/dto/location/AddressComponent;", "adrAddress", "", "formattedAddress", "geometry", "Lcom/findajob/jobamax/data/dto/location/Geometry;", "icon", "iconBackgroundColor", "iconMaskBaseUri", "name", "photos", "Lcom/findajob/jobamax/data/dto/location/Photo;", "placeId", "reference", "types", "url", "utcOffset", "", "vicinity", "website", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/findajob/jobamax/data/dto/location/Geometry;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAddressComponents", "()Ljava/util/List;", "getAdrAddress", "()Ljava/lang/String;", "getFormattedAddress", "getGeometry", "()Lcom/findajob/jobamax/data/dto/location/Geometry;", "getIcon", "getIconBackgroundColor", "getIconMaskBaseUri", "getName", "getPhotos", "getPlaceId", "getReference", "getTypes", "getUrl", "getUtcOffset", "()I", "getVicinity", "getWebsite", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Result {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "address_components")
    private final java.util.List<com.findajob.jobamax.data.dto.location.AddressComponent> addressComponents = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "adr_address")
    private final java.lang.String adrAddress = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "formatted_address")
    private final java.lang.String formattedAddress = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "geometry")
    private final com.findajob.jobamax.data.dto.location.Geometry geometry = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "icon")
    private final java.lang.String icon = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "icon_background_color")
    private final java.lang.String iconBackgroundColor = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "icon_mask_base_uri")
    private final java.lang.String iconMaskBaseUri = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "name")
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "photos")
    private final java.util.List<com.findajob.jobamax.data.dto.location.Photo> photos = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "place_id")
    private final java.lang.String placeId = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "reference")
    private final java.lang.String reference = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "types")
    private final java.util.List<java.lang.String> types = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "url")
    private final java.lang.String url = null;
    @com.google.gson.annotations.SerializedName(value = "utc_offset")
    private final int utcOffset = 0;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "vicinity")
    private final java.lang.String vicinity = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "website")
    private final java.lang.String website = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.data.dto.location.Result copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.findajob.jobamax.data.dto.location.AddressComponent> addressComponents, @org.jetbrains.annotations.NotNull()
    java.lang.String adrAddress, @org.jetbrains.annotations.NotNull()
    java.lang.String formattedAddress, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.data.dto.location.Geometry geometry, @org.jetbrains.annotations.NotNull()
    java.lang.String icon, @org.jetbrains.annotations.NotNull()
    java.lang.String iconBackgroundColor, @org.jetbrains.annotations.NotNull()
    java.lang.String iconMaskBaseUri, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.util.List<com.findajob.jobamax.data.dto.location.Photo> photos, @org.jetbrains.annotations.NotNull()
    java.lang.String placeId, @org.jetbrains.annotations.NotNull()
    java.lang.String reference, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> types, @org.jetbrains.annotations.NotNull()
    java.lang.String url, int utcOffset, @org.jetbrains.annotations.NotNull()
    java.lang.String vicinity, @org.jetbrains.annotations.NotNull()
    java.lang.String website) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Result(@org.jetbrains.annotations.NotNull()
    java.util.List<com.findajob.jobamax.data.dto.location.AddressComponent> addressComponents, @org.jetbrains.annotations.NotNull()
    java.lang.String adrAddress, @org.jetbrains.annotations.NotNull()
    java.lang.String formattedAddress, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.data.dto.location.Geometry geometry, @org.jetbrains.annotations.NotNull()
    java.lang.String icon, @org.jetbrains.annotations.NotNull()
    java.lang.String iconBackgroundColor, @org.jetbrains.annotations.NotNull()
    java.lang.String iconMaskBaseUri, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.util.List<com.findajob.jobamax.data.dto.location.Photo> photos, @org.jetbrains.annotations.NotNull()
    java.lang.String placeId, @org.jetbrains.annotations.NotNull()
    java.lang.String reference, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> types, @org.jetbrains.annotations.NotNull()
    java.lang.String url, int utcOffset, @org.jetbrains.annotations.NotNull()
    java.lang.String vicinity, @org.jetbrains.annotations.NotNull()
    java.lang.String website) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.findajob.jobamax.data.dto.location.AddressComponent> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.findajob.jobamax.data.dto.location.AddressComponent> getAddressComponents() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAdrAddress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFormattedAddress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.data.dto.location.Geometry component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.data.dto.location.Geometry getGeometry() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIcon() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIconBackgroundColor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIconMaskBaseUri() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.findajob.jobamax.data.dto.location.Photo> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.findajob.jobamax.data.dto.location.Photo> getPhotos() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPlaceId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReference() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTypes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUrl() {
        return null;
    }
    
    public final int component14() {
        return 0;
    }
    
    public final int getUtcOffset() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVicinity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWebsite() {
        return null;
    }
}