package com.findajob.jobamax.training.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J-\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\"\u0004\u0018\u00010\u0001H&\u00a2\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H&\u00a8\u0006\u0011"}, d2 = {"Lcom/findajob/jobamax/training/model/AGEventHandler;", "", "onExtraCallback", "", "type", "", "data", "", "(I[Ljava/lang/Object;)V", "onJoinChannelSuccess", "channel", "", "uid", "elapsed", "onUserOffline", "reason", "Companion", "app_debug"})
public abstract interface AGEventHandler {
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.training.model.AGEventHandler.Companion Companion = null;
    public static final int EVENT_TYPE_ON_USER_AUDIO_MUTED = 7;
    public static final int EVENT_TYPE_ON_SPEAKER_STATS = 8;
    public static final int EVENT_TYPE_ON_AGORA_MEDIA_ERROR = 9;
    public static final int EVENT_TYPE_ON_AUDIO_QUALITY = 10;
    public static final int EVENT_TYPE_ON_APP_ERROR = 13;
    public static final int EVENT_TYPE_ON_AUDIO_ROUTE_CHANGED = 18;
    
    public abstract void onJoinChannelSuccess(@org.jetbrains.annotations.Nullable()
    java.lang.String channel, int uid, int elapsed);
    
    public abstract void onUserOffline(int uid, int reason);
    
    public abstract void onExtraCallback(int type, @org.jetbrains.annotations.NotNull()
    java.lang.Object... data);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/findajob/jobamax/training/model/AGEventHandler$Companion;", "", "()V", "EVENT_TYPE_ON_AGORA_MEDIA_ERROR", "", "EVENT_TYPE_ON_APP_ERROR", "EVENT_TYPE_ON_AUDIO_QUALITY", "EVENT_TYPE_ON_AUDIO_ROUTE_CHANGED", "EVENT_TYPE_ON_SPEAKER_STATS", "EVENT_TYPE_ON_USER_AUDIO_MUTED", "app_debug"})
    public static final class Companion {
        public static final int EVENT_TYPE_ON_USER_AUDIO_MUTED = 7;
        public static final int EVENT_TYPE_ON_SPEAKER_STATS = 8;
        public static final int EVENT_TYPE_ON_AGORA_MEDIA_ERROR = 9;
        public static final int EVENT_TYPE_ON_AUDIO_QUALITY = 10;
        public static final int EVENT_TYPE_ON_APP_ERROR = 13;
        public static final int EVENT_TYPE_ON_AUDIO_ROUTE_CHANGED = 18;
        
        private Companion() {
            super();
        }
    }
}