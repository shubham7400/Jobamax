package com.findajob.jobamax.jobseeker.home;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u00ce\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJC\u0010_\u001a\u00020`2\u0016\u0010a\u001a\u0012\u0012\u0004\u0012\u00020b0Cj\b\u0012\u0004\u0012\u00020b`D2#\u0010c\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010e\u00a2\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020`0dJ3\u0010i\u001a\u00020`2\u0006\u0010j\u001a\u00020k2#\u0010c\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010e\u00a2\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020`0dJ&\u0010l\u001a\u00020`2\b\u0010m\u001a\u0004\u0018\u00010\u00122\u0014\u0010c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010e\u0012\u0004\u0012\u00020`0dJ3\u0010n\u001a\u00020`2\u0006\u0010o\u001a\u00020p2#\u0010c\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010e\u00a2\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020`0dJ$\u0010q\u001a\u00020`2\u0006\u0010r\u001a\u00020s2\u0014\u0010c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010e\u0012\u0004\u0012\u00020`0dJ3\u0010t\u001a\u00020`2\u0006\u0010r\u001a\u00020s2#\u0010c\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010e\u00a2\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020`0dJC\u0010u\u001a\u00020`2\u0016\u0010v\u001a\u0012\u0012\u0004\u0012\u00020b0Cj\b\u0012\u0004\u0012\u00020b`D2#\u0010c\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010e\u00a2\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020`0dJ3\u0010w\u001a\u00020`2\u0006\u0010x\u001a\u00020b2#\u0010c\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010e\u00a2\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020`0dJ\u0012\u0010y\u001a\u00020`2\n\b\u0002\u0010z\u001a\u0004\u0018\u00010bJ\u000e\u0010{\u001a\u00020`2\u0006\u0010c\u001a\u00020|J\u0012\u0010}\u001a\u0004\u0018\u00010\u00122\b\u0010~\u001a\u0004\u0018\u00010\u0012J\u000f\u0010\u007f\u001a\u00020`2\u0007\u0010c\u001a\u00030\u0080\u0001J\u0010\u0010\u0081\u0001\u001a\u00020`2\u0007\u0010c\u001a\u00030\u0080\u0001J\u0010\u0010\u0082\u0001\u001a\u00020`2\u0007\u0010c\u001a\u00030\u0080\u0001J\u0006\u0010M\u001a\u00020`JE\u0010\u0083\u0001\u001a\u00020`2\u0007\u0010\u0084\u0001\u001a\u00020b2\u0007\u0010\u0085\u0001\u001a\u00020b2\u0013\u0010\u0086\u0001\u001a\u000e\u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020`0d2\u0015\u0010\u0087\u0001\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010b\u0012\u0004\u0012\u00020`0dJE\u0010\u0088\u0001\u001a\u00020`2\u0007\u0010\u0084\u0001\u001a\u00020b2\u0007\u0010\u0085\u0001\u001a\u00020b2\u0013\u0010\u0086\u0001\u001a\u000e\u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020`0d2\u0015\u0010\u0087\u0001\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010b\u0012\u0004\u0012\u00020`0dJ\u0007\u0010\u0089\u0001\u001a\u00020`J\u0007\u0010[\u001a\u00030\u008a\u0001J\u0019\u0010\u008b\u0001\u001a\u00020`2\u0007\u0010c\u001a\u00030\u0080\u00012\u0007\u0010\u008c\u0001\u001a\u00020bJ\u0007\u0010\u008d\u0001\u001a\u00020`J\u0007\u0010\u008e\u0001\u001a\u00020`J\u0007\u0010\u008f\u0001\u001a\u00020`J\u0010\u0010\u0090\u0001\u001a\u00020`2\u0007\u0010c\u001a\u00030\u0080\u0001J\u0010\u0010\u0091\u0001\u001a\u00020`2\u0007\u0010\u0092\u0001\u001a\u00020bJ\u0010\u0010\u0093\u0001\u001a\u00020`2\u0007\u0010\u0092\u0001\u001a\u00020bJ6\u0010\u0094\u0001\u001a\u00020`2\b\u0010\u0095\u0001\u001a\u00030\u0096\u00012#\u0010c\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010e\u00a2\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020`0dJ\u0007\u0010\u0097\u0001\u001a\u00020`J\u0011\u0010\u0098\u0001\u001a\u00030\u008a\u00012\u0007\u0010\u0099\u0001\u001a\u00020\u0014JE\u0010\u009a\u0001\u001a\u00020`2\u0017\u0010\u009b\u0001\u001a\u0012\u0012\u0004\u0012\u00020p0Cj\b\u0012\u0004\u0012\u00020p`D2#\u0010c\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010e\u00a2\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020`0dJ6\u0010\u009c\u0001\u001a\u00020`2\u0017\u0010\u009d\u0001\u001a\u0012\u0012\u0004\u0012\u00020k0Cj\b\u0012\u0004\u0012\u00020k`D2\u0014\u0010c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010e\u0012\u0004\u0012\u00020`0dJ6\u0010\u009e\u0001\u001a\u00020`2\u0017\u0010\u009f\u0001\u001a\u0012\u0012\u0004\u0012\u00020s0Cj\b\u0012\u0004\u0012\u00020s`D2\u0014\u0010c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010e\u0012\u0004\u0012\u00020`0dJ\u0019\u0010\u00a0\u0001\u001a\u00020`2\u0007\u0010\u00a1\u0001\u001a\u00020b2\u0007\u0010c\u001a\u00030\u00a2\u0001J8\u0010\u00a3\u0001\u001a\u00020`2\u0007\u0010\u00a4\u0001\u001a\u00020b2\u0007\u0010\u00a5\u0001\u001a\u00020b2\u0007\u0010\u00a6\u0001\u001a\u00020b2\u0014\u0010c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010e\u0012\u0004\u0012\u00020`0dJ\u0010\u0010\u00a7\u0001\u001a\u00020`2\u0007\u0010\u0092\u0001\u001a\u00020bJ6\u0010\u00a8\u0001\u001a\u00020`2\b\u0010\u00a9\u0001\u001a\u00030\u00aa\u00012#\u0010c\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010e\u00a2\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020`0dJ\u0010\u0010\u00ab\u0001\u001a\u00020`2\u0007\u0010\u0092\u0001\u001a\u00020bJ6\u0010\u00ac\u0001\u001a\u00020`2\b\u0010\u00ad\u0001\u001a\u00030\u00ae\u00012#\u0010c\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010e\u00a2\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020`0dJ\u001c\u0010\u00af\u0001\u001a\u00030\u008a\u00012\b\u0010\u00b0\u0001\u001a\u00030\u00b1\u00012\b\u0010\u00b2\u0001\u001a\u00030\u00b1\u0001J\"\u0010\u00b3\u0001\u001a\u00020`2\u0007\u0010\u00b4\u0001\u001a\u00020\u000b2\u0007\u0010\u00b5\u0001\u001a\u00020b2\u0007\u0010c\u001a\u00030\u00b6\u0001JP\u0010\u00b7\u0001\u001a\u00020`2\u0007\u0010\u00b8\u0001\u001a\u00020b2\u0007\u0010\u00b9\u0001\u001a\u00020b2\u0007\u0010\u00ba\u0001\u001a\u00020b2\u0007\u0010\u00bb\u0001\u001a\u00020b2#\u0010c\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010e\u00a2\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020`0dJ\u0010\u0010\u00bc\u0001\u001a\u00020`2\u0007\u0010\u00b4\u0001\u001a\u00020\u000bJ\u0010\u0010\u00bd\u0001\u001a\u00020`2\u0007\u0010\u00b4\u0001\u001a\u00020\u000bJ\u0019\u0010\u00be\u0001\u001a\u00020`2\u0007\u0010\u00bf\u0001\u001a\u00020\u001d2\u0007\u0010c\u001a\u00030\u00b6\u0001J6\u0010\u00c0\u0001\u001a\u00020`2\b\u0010\u00c1\u0001\u001a\u00030\u00c2\u00012#\u0010c\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010e\u00a2\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020`0dJ&\u0010\u00c3\u0001\u001a\u00020`2\u0007\u0010\u00c4\u0001\u001a\u00020\u00122\u0014\u0010c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010e\u0012\u0004\u0012\u00020`0dJ?\u0010\u00c5\u0001\u001a\u00020`2\b\u0010\u00c6\u0001\u001a\u00030\u00c7\u00012\u0015\u0010\u0086\u0001\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010e\u0012\u0004\u0012\u00020`0d2\u0015\u0010\u0087\u0001\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010b\u0012\u0004\u0012\u00020`0dJ\u001a\u0010\u00c8\u0001\u001a\u00020`2\b\u0010\u00c9\u0001\u001a\u00030\u00c7\u00012\u0007\u0010c\u001a\u00030\u00ca\u0001JA\u0010\u00cb\u0001\u001a\u00020`2\n\u0010\u00cc\u0001\u001a\u0005\u0018\u00010\u00cd\u00012\u0015\u0010\u0086\u0001\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010e\u0012\u0004\u0012\u00020`0d2\u0015\u0010\u0087\u0001\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010b\u0012\u0004\u0012\u00020`0dR!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00180\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R!\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0)8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010\u000f\u001a\u0004\b*\u0010+R\u001a\u0010-\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b&\u0010/R\u001a\u00100\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010.\"\u0004\b1\u0010/R \u00102\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\r\"\u0004\b3\u00104R\u001a\u00105\u001a\u000206X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001d\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110)\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010+R\u001a\u0010=\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001f\"\u0004\b?\u0010!R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010AR*\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u00120Cj\b\u0012\u0004\u0012\u00020\u0012`DX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00140)\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010+R\u0011\u0010K\u001a\u00020L8F\u00a2\u0006\u0006\u001a\u0004\bM\u0010NR\u001c\u0010O\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0017\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00160\n\u00a2\u0006\b\n\u0000\u001a\u0004\bW\u0010\rR#\u0010X\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00180)\u00a2\u0006\b\n\u0000\u001a\u0004\bY\u0010+R\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00120)\u00a2\u0006\b\n\u0000\u001a\u0004\b[\u0010+R\u001a\u0010\\\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u0010%\"\u0004\b^\u0010\'\u00a8\u0006\u00cf\u0001"}, d2 = {"Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "Lcom/findajob/jobamax/base/BaseAndroidViewModel;", "context", "Landroid/app/Application;", "jobSeekerRepo", "Lcom/findajob/jobamax/repo/JobSeekerRepo;", "jobOfferRepo", "Lcom/findajob/jobamax/repo/JobOfferRepository;", "(Landroid/app/Application;Lcom/findajob/jobamax/repo/JobSeekerRepo;Lcom/findajob/jobamax/repo/JobOfferRepository;)V", "_deleteAccountStatus", "Landroidx/lifecycle/MutableLiveData;", "", "get_deleteAccountStatus", "()Landroidx/lifecycle/MutableLiveData;", "_deleteAccountStatus$delegate", "Lkotlin/Lazy;", "_jobOfferLiveData", "", "Lcom/parse/ParseObject;", "_jobSearchStateObservable", "Lcom/findajob/jobamax/jobseeker/profile/jobSearch/JobSearchState;", "_jobSeekerTrackStateLiveData", "Lcom/findajob/jobamax/jobseeker/track/JobSeekerTrackState;", "_pushNotificationStateObserver", "Lkotlin/Pair;", "_selectedJobOffer", "getContext", "()Landroid/app/Application;", "currentIndex", "", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "currentLocation", "Lcom/parse/ParseGeoPoint;", "getCurrentLocation", "()Lcom/parse/ParseGeoPoint;", "setCurrentLocation", "(Lcom/parse/ParseGeoPoint;)V", "deleteAccountLiveData", "Landroidx/lifecycle/LiveData;", "getDeleteAccountLiveData", "()Landroidx/lifecycle/LiveData;", "deleteAccountLiveData$delegate", "isCurrentLocation", "()Z", "(Z)V", "isJobOfferExhausted", "setJobOfferExhausted", "isJobSeekerUpdated", "setJobSeekerUpdated", "(Landroidx/lifecycle/MutableLiveData;)V", "jobOfferButtonCallback", "Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel$JobOfferButtonCallback;", "getJobOfferButtonCallback", "()Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel$JobOfferButtonCallback;", "setJobOfferButtonCallback", "(Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel$JobOfferButtonCallback;)V", "jobOfferLiveData", "getJobOfferLiveData", "jobOfferPageIndex", "getJobOfferPageIndex", "setJobOfferPageIndex", "getJobOfferRepo", "()Lcom/findajob/jobamax/repo/JobOfferRepository;", "jobOffers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getJobOffers", "()Ljava/util/ArrayList;", "setJobOffers", "(Ljava/util/ArrayList;)V", "jobSearchStateObservable", "getJobSearchStateObservable", "jobSeeker", "Lcom/findajob/jobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/findajob/jobamax/model/JobSeeker;", "jobSeekerObject", "getJobSeekerObject", "()Lcom/parse/ParseObject;", "setJobSeekerObject", "(Lcom/parse/ParseObject;)V", "getJobSeekerRepo", "()Lcom/findajob/jobamax/repo/JobSeekerRepo;", "jobSeekerTrackStateLiveData", "getJobSeekerTrackStateLiveData", "pushNotificationStateObserver", "getPushNotificationStateObserver", "selectedJobOffer", "getSelectedJobOffer", "selectedLocation", "getSelectedLocation", "setSelectedLocation", "addActivitiesTags", "", "activitiesTags", "", "callback", "Lkotlin/Function1;", "Lcom/parse/ParseException;", "Lkotlin/ParameterName;", "name", "it", "addAndUpdateExperience", "experience", "Lcom/findajob/jobamax/jobseeker/profile/cv/model/Experience;", "addJobToTack", "trackingJob", "addNewOrUpdateEducation", "education", "Lcom/findajob/jobamax/jobseeker/profile/cv/model/Education;", "addNewOrUpdateVolunteering", "volunteering", "Lcom/findajob/jobamax/jobseeker/profile/cv/model/Volunteering;", "addOrUpdateVolunteering", "addWorkSpace", "ownedWorkSpaces", "changePassword", "newPassword", "deleteAccount", "reasons", "getCardDetails", "Lcom/findajob/jobamax/model/GetCardDetailsCallback;", "getCompanyFromJobOffer", "jobOfferParseObject", "getExistingActivitiesTags", "Lcom/findajob/jobamax/model/GetAllUserCallback;", "getExistingHardSkillTags", "getExistingSoftSkillTags", "getNextDeadline", "phase", "jobSeekerId", "onFailure", "onSuccess", "getNextInterview", "getPushNotificationState", "Lkotlinx/coroutines/Job;", "getWishList", "filteredJob", "loadAllJobOffers", "loadAppliedJobs", "loadJobOffers", "loadTrackingJob", "saveActivitiesTag", "tag", "saveHardSkillTag", "saveHardSkills", "hardSkillJsonObj", "Lorg/json/JSONObject;", "saveJobSearch", "saveJobSearchState", "jobSearchState", "saveNewEducationList", "educations", "saveNewExperienceList", "experiences", "saveNewVolunteeringList", "volunteerings", "savePaymentMethod", "paymentMethodId", "Lcom/findajob/jobamax/model/SaveCardDetailsCallback;", "saveSocialMediaLinks", "instagramLink", "linkedInLink", "tikTokLink", "saveSoftSkillTag", "saveSoftSkills", "softSkillJsonArray", "Lorg/json/JSONArray;", "saveVolunteeringTag", "submitData", "personalInfoModel", "Lcom/findajob/jobamax/jobseeker/profile/account/personalInfo/JobSeekerPersonalInformationModel;", "submitLocation", "lat", "", "lng", "updateFlag", "flag", "key", "Lcom/findajob/jobamax/model/UpdateUserCallback;", "updateJobSeeker", "firstName", "lastName", "profession", "description", "updateMessagePushNotificationFlag", "updateNewsMatchesPushNotificationFlag", "updateReachCount", "reachCount", "updateSocialMediaLinks", "socialMedia", "Lcom/findajob/jobamax/jobseeker/profile/account/social/JobSeekerSocialAccountModel;", "updateWishlistJob", "parseObject", "uploadImage", "uri", "Landroid/net/Uri;", "uploadProfilePicUri", "profilePicUri", "Lcom/findajob/jobamax/repo/SaveParseObjectCallback;", "uploadUserAudio", "bytes", "", "JobOfferButtonCallback", "app_debug"})
public final class JobSeekerHomeViewModel extends com.findajob.jobamax.base.BaseAndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.findajob.jobamax.repo.JobSeekerRepo jobSeekerRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final com.findajob.jobamax.repo.JobOfferRepository jobOfferRepo = null;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject jobSeekerObject;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.parse.ParseObject> jobOffers;
    private int jobOfferPageIndex = 0;
    private boolean isJobOfferExhausted = false;
    @org.jetbrains.annotations.NotNull()
    private com.parse.ParseGeoPoint selectedLocation;
    @org.jetbrains.annotations.NotNull()
    private com.parse.ParseGeoPoint currentLocation;
    private boolean isCurrentLocation = true;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.parse.ParseObject>> _jobOfferLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.parse.ParseObject>> jobOfferLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isJobSeekerUpdated;
    private int currentIndex = 0;
    @org.jetbrains.annotations.NotNull()
    private com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel.JobOfferButtonCallback jobOfferButtonCallback = com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel.JobOfferButtonCallback.NONE;
    private final androidx.lifecycle.MutableLiveData<com.findajob.jobamax.jobseeker.track.JobSeekerTrackState> _jobSeekerTrackStateLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.findajob.jobamax.jobseeker.track.JobSeekerTrackState> jobSeekerTrackStateLiveData = null;
    private final androidx.lifecycle.MutableLiveData<com.parse.ParseObject> _selectedJobOffer = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.parse.ParseObject> selectedJobOffer = null;
    private final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.Boolean, java.lang.Boolean>> _pushNotificationStateObserver = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<kotlin.Pair<java.lang.Boolean, java.lang.Boolean>> pushNotificationStateObserver = null;
    private final androidx.lifecycle.MutableLiveData<com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState> _jobSearchStateObservable = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState> jobSearchStateObservable = null;
    private final kotlin.Lazy _deleteAccountStatus$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy deleteAccountLiveData$delegate = null;
    
    @javax.inject.Inject()
    public JobSeekerHomeViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application context, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.JobSeekerRepo jobSeekerRepo, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.JobOfferRepository jobOfferRepo) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.repo.JobSeekerRepo getJobSeekerRepo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.repo.JobOfferRepository getJobOfferRepo() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getJobSeekerObject() {
        return null;
    }
    
    public final void setJobSeekerObject(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.parse.ParseObject> getJobOffers() {
        return null;
    }
    
    public final void setJobOffers(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.parse.ParseObject> p0) {
    }
    
    public final int getJobOfferPageIndex() {
        return 0;
    }
    
    public final void setJobOfferPageIndex(int p0) {
    }
    
    public final boolean isJobOfferExhausted() {
        return false;
    }
    
    public final void setJobOfferExhausted(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.parse.ParseGeoPoint getSelectedLocation() {
        return null;
    }
    
    public final void setSelectedLocation(@org.jetbrains.annotations.NotNull()
    com.parse.ParseGeoPoint p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.parse.ParseGeoPoint getCurrentLocation() {
        return null;
    }
    
    public final void setCurrentLocation(@org.jetbrains.annotations.NotNull()
    com.parse.ParseGeoPoint p0) {
    }
    
    public final boolean isCurrentLocation() {
        return false;
    }
    
    public final void setCurrentLocation(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.JobSeeker getJobSeeker() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.parse.ParseObject>> getJobOfferLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isJobSeekerUpdated() {
        return null;
    }
    
    public final void setJobSeekerUpdated(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    public final int getCurrentIndex() {
        return 0;
    }
    
    public final void setCurrentIndex(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel.JobOfferButtonCallback getJobOfferButtonCallback() {
        return null;
    }
    
    public final void setJobOfferButtonCallback(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel.JobOfferButtonCallback p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.findajob.jobamax.jobseeker.track.JobSeekerTrackState> getJobSeekerTrackStateLiveData() {
        return null;
    }
    
    public final void getJobSeeker() {
    }
    
    public final void loadAppliedJobs() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.parse.ParseObject> getSelectedJobOffer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getSelectedJobOffer() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getCompanyFromJobOffer(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject jobOfferParseObject) {
        return null;
    }
    
    public final void loadJobOffers() {
    }
    
    /**
     * load Jobamax, Adzuna, and Remotive job offers
     */
    public final void loadAllJobOffers() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<kotlin.Pair<java.lang.Boolean, java.lang.Boolean>> getPushNotificationStateObserver() {
        return null;
    }
    
    public final void getPushNotificationState() {
    }
    
    public final void updateMessagePushNotificationFlag(boolean flag) {
    }
    
    public final void updateNewsMatchesPushNotificationFlag(boolean flag) {
    }
    
    public final void updateFlag(boolean flag, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.UpdateUserCallback callback) {
    }
    
    public final void submitData(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationModel personalInfoModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void updateSocialMediaLinks(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.profile.account.social.JobSeekerSocialAccountModel socialMedia, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void updateReachCount(int reachCount, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.UpdateUserCallback callback) {
    }
    
    public final void uploadProfilePicUri(@org.jetbrains.annotations.NotNull()
    android.net.Uri profilePicUri, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.SaveParseObjectCallback callback) {
    }
    
    public final void savePaymentMethod(@org.jetbrains.annotations.NotNull()
    java.lang.String paymentMethodId, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.SaveCardDetailsCallback callback) {
    }
    
    public final void getCardDetails(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.GetCardDetailsCallback callback) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState> getJobSearchStateObservable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job saveJobSearchState(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState jobSearchState) {
        return null;
    }
    
    public final void saveJobSearch() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job submitLocation(double lat, double lng) {
        return null;
    }
    
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> get_deleteAccountStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getDeleteAccountLiveData() {
        return null;
    }
    
    public final void deleteAccount(@org.jetbrains.annotations.Nullable()
    java.lang.String reasons) {
    }
    
    public final void changePassword(@org.jetbrains.annotations.NotNull()
    java.lang.String newPassword, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void updateJobSeeker(@org.jetbrains.annotations.NotNull()
    java.lang.String firstName, @org.jetbrains.annotations.NotNull()
    java.lang.String lastName, @org.jetbrains.annotations.NotNull()
    java.lang.String profession, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void addNewOrUpdateEducation(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.profile.cv.model.Education education, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void saveNewEducationList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.jobseeker.profile.cv.model.Education> educations, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void saveHardSkills(@org.jetbrains.annotations.NotNull()
    org.json.JSONObject hardSkillJsonObj, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void saveSoftSkills(@org.jetbrains.annotations.NotNull()
    org.json.JSONArray softSkillJsonArray, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void addWorkSpace(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> ownedWorkSpaces, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void addActivitiesTags(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> activitiesTags, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void addAndUpdateExperience(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.profile.cv.model.Experience experience, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void saveNewExperienceList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.jobseeker.profile.cv.model.Experience> experiences, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void getExistingHardSkillTags(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.GetAllUserCallback callback) {
    }
    
    public final void saveHardSkillTag(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
    
    public final void getExistingSoftSkillTags(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.GetAllUserCallback callback) {
    }
    
    public final void saveSoftSkillTag(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
    
    public final void getExistingActivitiesTags(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.GetAllUserCallback callback) {
    }
    
    public final void saveVolunteeringTag(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
    
    public final void saveActivitiesTag(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
    
    public final void saveSocialMediaLinks(@org.jetbrains.annotations.NotNull()
    java.lang.String instagramLink, @org.jetbrains.annotations.NotNull()
    java.lang.String linkedInLink, @org.jetbrains.annotations.NotNull()
    java.lang.String tikTokLink, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void getWishList(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.GetAllUserCallback callback, @org.jetbrains.annotations.NotNull()
    java.lang.String filteredJob) {
    }
    
    public final void updateWishlistJob(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject parseObject, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void addJobToTack(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject trackingJob, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void uploadUserAudio(@org.jetbrains.annotations.Nullable()
    byte[] bytes, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> onFailure, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSuccess) {
    }
    
    public final void uploadImage(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> onFailure, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSuccess) {
    }
    
    public final void loadTrackingJob(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.GetAllUserCallback callback) {
    }
    
    public final void getNextInterview(@org.jetbrains.annotations.NotNull()
    java.lang.String phase, @org.jetbrains.annotations.NotNull()
    java.lang.String jobSeekerId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> onFailure, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSuccess) {
    }
    
    public final void getNextDeadline(@org.jetbrains.annotations.NotNull()
    java.lang.String phase, @org.jetbrains.annotations.NotNull()
    java.lang.String jobSeekerId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> onFailure, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSuccess) {
    }
    
    public final void addOrUpdateVolunteering(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.profile.cv.model.Volunteering volunteering, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void saveNewVolunteeringList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.jobseeker.profile.cv.model.Volunteering> volunteerings, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void addNewOrUpdateVolunteering(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.profile.cv.model.Volunteering volunteering, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel$JobOfferButtonCallback;", "", "(Ljava/lang/String;I)V", "NONE", "CHAT", "REJECT", "ACCEPT", "app_debug"})
    public static enum JobOfferButtonCallback {
        /*public static final*/ NONE /* = new NONE() */,
        /*public static final*/ CHAT /* = new CHAT() */,
        /*public static final*/ REJECT /* = new REJECT() */,
        /*public static final*/ ACCEPT /* = new ACCEPT() */;
        
        JobOfferButtonCallback() {
        }
    }
}