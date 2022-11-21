package com.jobamax.appjobamax.model;

import java.io.Serializable;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR*\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR*\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u001d\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR*\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010\u00a8\u0006#"}, d2 = {"Lcom/jobamax/appjobamax/model/Matches;", "Ljava/io/Serializable;", "()V", "educationPer", "", "getEducationPer", "()I", "setEducationPer", "(I)V", "educations", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/model/MatchTag;", "Lkotlin/collections/ArrayList;", "getEducations", "()Ljava/util/ArrayList;", "setEducations", "(Ljava/util/ArrayList;)V", "experiencePer", "getExperiencePer", "setExperiencePer", "experiences", "getExperiences", "setExperiences", "hardSkillPer", "getHardSkillPer", "setHardSkillPer", "hardSkills", "getHardSkills", "setHardSkills", "softSkillPer", "getSoftSkillPer", "setSoftSkillPer", "softSkills", "getSoftSkills", "setSoftSkills", "app_debug"})
public final class Matches implements java.io.Serializable {
    private int educationPer = 0;
    private int hardSkillPer = 0;
    private int softSkillPer = 0;
    private int experiencePer = 0;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.MatchTag> softSkills;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.MatchTag> hardSkills;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.MatchTag> educations;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.MatchTag> experiences;
    
    public Matches() {
        super();
    }
    
    public final int getEducationPer() {
        return 0;
    }
    
    public final void setEducationPer(int p0) {
    }
    
    public final int getHardSkillPer() {
        return 0;
    }
    
    public final void setHardSkillPer(int p0) {
    }
    
    public final int getSoftSkillPer() {
        return 0;
    }
    
    public final void setSoftSkillPer(int p0) {
    }
    
    public final int getExperiencePer() {
        return 0;
    }
    
    public final void setExperiencePer(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.MatchTag> getSoftSkills() {
        return null;
    }
    
    public final void setSoftSkills(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.MatchTag> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.MatchTag> getHardSkills() {
        return null;
    }
    
    public final void setHardSkills(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.MatchTag> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.MatchTag> getEducations() {
        return null;
    }
    
    public final void setEducations(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.MatchTag> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.MatchTag> getExperiences() {
        return null;
    }
    
    public final void setExperiences(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.MatchTag> p0) {
    }
}