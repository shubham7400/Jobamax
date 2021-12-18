package com.findajob.jobamax.recruiter.home;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u00fc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001a\u0010\u00b4\u0001\u001a\u00030\u00b5\u00012\u0007\u0010\u00b6\u0001\u001a\u00020\u000e2\u0007\u0010\u00b7\u0001\u001a\u00020\u0012J\u0011\u0010\u00b8\u0001\u001a\u00030\u00b5\u00012\u0007\u0010\u00b9\u0001\u001a\u00020\u0012J\u0011\u0010\u00ba\u0001\u001a\u00030\u00bb\u00012\u0007\u0010\u00b6\u0001\u001a\u00020\u000eJ\u0015\u0010\u00bc\u0001\u001a\u00030\u00b5\u00012\u000b\b\u0002\u0010\u00bd\u0001\u001a\u0004\u0018\u00010\u0012J\u0013\u0010\u00be\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0%J\u0013\u0010\u00bf\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0%J\u0012\u0010\u00c0\u0001\u001a\u00030\u00b5\u00012\b\u0010\u00c1\u0001\u001a\u00030\u00c2\u0001J\r\u0010\u00c3\u0001\u001a\b\u0012\u0004\u0012\u00020<0%J\b\u0010\u00c4\u0001\u001a\u00030\u00b5\u0001J\u0011\u0010\u00c5\u0001\u001a\u00030\u00b5\u00012\u0007\u0010\u00b9\u0001\u001a\u00020\u0012J\u0013\u0010\u00c6\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0%J\b\u0010\u008f\u0001\u001a\u00030\u00b5\u0001J\b\u0010\u00c7\u0001\u001a\u00030\u00c8\u0001J\b\u0010\u00c9\u0001\u001a\u00030\u00b5\u0001J\b\u0010\u00ca\u0001\u001a\u00030\u00c8\u0001J\b\u0010\u00cb\u0001\u001a\u00030\u00c8\u0001J\b\u0010\u00cc\u0001\u001a\u00030\u00b5\u0001J\b\u0010\u00cd\u0001\u001a\u00030\u00b5\u0001J\u0011\u0010\u00ce\u0001\u001a\u00030\u00bb\u00012\u0007\u0010\u00cf\u0001\u001a\u00020\u000eJ\u0011\u0010\u00d0\u0001\u001a\u00030\u00b5\u00012\u0007\u0010\u00b6\u0001\u001a\u00020\u000eJ\u0011\u0010\u00d1\u0001\u001a\u00030\u00b5\u00012\u0007\u0010\u00b6\u0001\u001a\u00020\u000eJ\u001a\u0010\u00d2\u0001\u001a\u00030\u00b5\u00012\u0006\u0010;\u001a\u00020<2\b\u0010\u00c1\u0001\u001a\u00030\u00d3\u0001J\u0010\u0010\u00d4\u0001\u001a\u00030\u00bb\u00012\u0006\u0010;\u001a\u00020<J\u001e\u0010\u00d5\u0001\u001a\u00030\u00b5\u00012\n\u0010\u00d6\u0001\u001a\u0005\u0018\u00010\u00d7\u00012\b\u0010\u00c1\u0001\u001a\u00030\u00d8\u0001J\u0014\u0010\u00d9\u0001\u001a\u00030\u00b5\u00012\b\u0010\u00c1\u0001\u001a\u00030\u00d8\u0001H\u0002J\u0012\u0010\u00da\u0001\u001a\u00030\u00bb\u00012\b\u0010\u00cf\u0001\u001a\u00030\u00db\u0001J\u001b\u0010\u00dc\u0001\u001a\u00030\u00b5\u00012\u0007\u0010\u00dd\u0001\u001a\u00020\u00122\b\u0010\u00c1\u0001\u001a\u00030\u00de\u0001J\u0013\u0010\u00df\u0001\u001a\u00030\u00b5\u00012\u0007\u0010\u00e0\u0001\u001a\u00020\u0012H\u0002J\u0014\u0010\u00e1\u0001\u001a\u00030\u00b5\u00012\b\u0010\u00e2\u0001\u001a\u00030\u00e3\u0001H\u0002J\u001a\u0010\u00e4\u0001\u001a\u00030\u00b5\u00012\u0007\u0010\u00e5\u0001\u001a\u00020\u00122\u0007\u0010\u00e6\u0001\u001a\u00020\u0012J>\u0010\u00e7\u0001\u001a\u00030\u00b5\u00012\b\u0010\u00e8\u0001\u001a\u00030\u00e9\u00012*\u0010\u00c1\u0001\u001a%\u0012\u0019\u0012\u0017\u0018\u00010\u00eb\u0001\u00a2\u0006\u000f\b\u00ec\u0001\u0012\n\b\u00ed\u0001\u0012\u0005\b\b(\u00ee\u0001\u0012\u0005\u0012\u00030\u00b5\u00010\u00ea\u0001J\u0011\u0010\u00ef\u0001\u001a\u00030\u00b5\u00012\u0007\u0010\u00b9\u0001\u001a\u00020\u0012J\u0011\u0010\u00f0\u0001\u001a\u00030\u00b5\u00012\u0007\u0010\u00b6\u0001\u001a\u00020\u000eJ\u0011\u0010\u00f1\u0001\u001a\u00030\u00b5\u00012\u0007\u0010\u00b6\u0001\u001a\u00020\u000eJ\u001a\u0010\u00f2\u0001\u001a\u00030\u00b5\u00012\u0006\u0010;\u001a\u00020<2\b\u0010\u00c1\u0001\u001a\u00030\u00d3\u0001J$\u0010\u00f3\u0001\u001a\u00030\u00b5\u00012\u0007\u0010\u00f4\u0001\u001a\u00020\u00132\u0007\u0010\u00f5\u0001\u001a\u00020\u00122\b\u0010\u00c1\u0001\u001a\u00030\u00f6\u0001J\u0011\u0010\u00f7\u0001\u001a\u00030\u00bb\u00012\u0007\u0010\u00f4\u0001\u001a\u00020\u0013J\u0011\u0010\u00f8\u0001\u001a\u00030\u00bb\u00012\u0007\u0010\u00f4\u0001\u001a\u00020\u0013J>\u0010\u00f9\u0001\u001a\u00030\u00b5\u00012\b\u0010\u00fa\u0001\u001a\u00030\u00fb\u00012*\u0010\u00c1\u0001\u001a%\u0012\u0019\u0012\u0017\u0018\u00010\u00eb\u0001\u00a2\u0006\u000f\b\u00ec\u0001\u0012\n\b\u00ed\u0001\u0012\u0005\b\b(\u00ee\u0001\u0012\u0005\u0012\u00030\u00b5\u00010\u00ea\u0001J\u001c\u0010\u00fc\u0001\u001a\u00030\u00b5\u00012\b\u0010\u00fd\u0001\u001a\u00030\u00d7\u00012\b\u0010\u00c1\u0001\u001a\u00030\u00d3\u0001R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0%\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R \u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0%\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\'R \u00100\u001a\b\u0012\u0004\u0012\u00020\u000e01X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110%\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010\'R\u001d\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0%\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010\'R\u0011\u0010;\u001a\u00020<8F\u00a2\u0006\u0006\u001a\u0004\b=\u0010>R\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00130%\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010\'R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020<0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010B\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010D\"\u0004\bM\u0010FR\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00170%\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u0010\'R\u001b\u0010P\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bR\u0010\u001c\u001a\u0004\bQ\u0010DR\u001b\u0010S\u001a\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bV\u0010\u001c\u001a\u0004\bT\u0010UR!\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00130%8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bY\u0010\u001c\u001a\u0004\bX\u0010\'R\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00120%\u00a2\u0006\b\n\u0000\u001a\u0004\b[\u0010\'R\u001d\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0%\u00a2\u0006\b\n\u0000\u001a\u0004\b]\u0010\'R\u001a\u0010^\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001a\u0010b\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bb\u0010_\"\u0004\bc\u0010aR\u001a\u0010d\u001a\u00020eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001d\u0010n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0%\u00a2\u0006\b\n\u0000\u001a\u0004\bo\u0010\'R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR \u0010t\u001a\b\u0012\u0004\u0012\u00020\u000e01X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bu\u00103\"\u0004\bv\u00105R\u0017\u0010w\u001a\b\u0012\u0004\u0012\u00020\u000e0%\u00a2\u0006\b\n\u0000\u001a\u0004\bx\u0010\'R\u001a\u0010y\u001a\u00020zX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u001c\u0010\u007f\u001a\u00020zX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010|\"\u0005\b\u0081\u0001\u0010~R\u0010\u0010\u0082\u0001\u001a\u00030\u0083\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e01X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u00103\"\u0005\b\u0086\u0001\u00105R\u001b\u0010\u0087\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0088\u0001\u001a\u00020zX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010|\"\u0005\b\u008a\u0001\u0010~R\u001d\u0010\u008b\u0001\u001a\u00020zX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010|\"\u0005\b\u008d\u0001\u0010~R\u0014\u0010\u008e\u0001\u001a\u00020\u00178F\u00a2\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010D\"\u0005\b\u0093\u0001\u0010FR\u001e\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R \u0010\u0098\u0001\u001a\u00030\u0099\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u009c\u0001\u0010\u001c\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0001\u0010D\"\u0005\b\u009f\u0001\u0010FR\u001e\u0010\u00a0\u0001\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u0011\n\u0000\u001a\u0005\b\u00a1\u0001\u0010U\"\u0006\b\u00a2\u0001\u0010\u00a3\u0001R\u0019\u0010\u00a4\u0001\u001a\b\u0012\u0004\u0012\u00020\"0%\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00a5\u0001\u0010\'R\u001d\u0010\u00a6\u0001\u001a\u00020zX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a7\u0001\u0010|\"\u0005\b\u00a8\u0001\u0010~R\u001d\u0010\u00a9\u0001\u001a\u00020zX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00aa\u0001\u0010|\"\u0005\b\u00ab\u0001\u0010~R\u001d\u0010\u00ac\u0001\u001a\u00020zX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ad\u0001\u0010|\"\u0005\b\u00ae\u0001\u0010~R\u001d\u0010\u00af\u0001\u001a\u00020zX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b0\u0001\u0010|\"\u0005\b\u00b1\u0001\u0010~R%\u0010\u00b2\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110%\u00a2\u0006\t\n\u0000\u001a\u0005\b\u00b3\u0001\u0010\'\u00a8\u0006\u00fe\u0001"}, d2 = {"Lcom/findajob/jobamax/recruiter/home/RecruiterHomeViewModel;", "Lcom/findajob/jobamax/base/BaseAndroidViewModel;", "jobSeekerRepo", "Lcom/findajob/jobamax/repo/JobSeekerRepo;", "jobOfferRepo", "Lcom/findajob/jobamax/repo/JobOfferRepository;", "recruiterRepo", "Lcom/findajob/jobamax/repo/RecruiterRepo;", "context", "Landroid/app/Application;", "(Lcom/findajob/jobamax/repo/JobSeekerRepo;Lcom/findajob/jobamax/repo/JobOfferRepository;Lcom/findajob/jobamax/repo/RecruiterRepo;Landroid/app/Application;)V", "_activeJObOffersObservable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/parse/ParseObject;", "_allJObOffersObservable", "_archiveJobOfferSuccess", "Lkotlin/Pair;", "", "", "_archivedJObOffersObservable", "_companyDataSaveListener", "_currentRecruiterObservable", "Lcom/findajob/jobamax/model/Recruiter;", "_deleteAccountStatus", "get_deleteAccountStatus", "()Landroidx/lifecycle/MutableLiveData;", "_deleteAccountStatus$delegate", "Lkotlin/Lazy;", "_errorText", "_filteredJobOffers", "_jobSeekerLiveData", "_jobSourceObservable", "_selectedJobOfferObservable", "Lcom/findajob/jobamax/model/JobOffer;", "_unarchiveJobOfferSuccess", "activeJobOffersObservable", "Landroidx/lifecycle/LiveData;", "getActiveJobOffersObservable", "()Landroidx/lifecycle/LiveData;", "allJobOffers", "getAllJobOffers", "()Ljava/util/List;", "setAllJobOffers", "(Ljava/util/List;)V", "allJobOffersLiveData", "allJobOffersObservable", "getAllJobOffersObservable", "applicants", "Ljava/util/ArrayList;", "getApplicants", "()Ljava/util/ArrayList;", "setApplicants", "(Ljava/util/ArrayList;)V", "applicantsLiveData", "archiveJobOfferSuccess", "getArchiveJobOfferSuccess", "archivedJobOffersObservable", "getArchivedJobOffersObservable", "company", "Lcom/findajob/jobamax/model/Company;", "getCompany", "()Lcom/findajob/jobamax/model/Company;", "companyDataSaveListener", "getCompanyDataSaveListener", "companyLiveData", "companyParseObject", "getCompanyParseObject", "()Lcom/parse/ParseObject;", "setCompanyParseObject", "(Lcom/parse/ParseObject;)V", "getContext", "()Landroid/app/Application;", "setContext", "(Landroid/app/Application;)V", "currentJobOffer", "getCurrentJobOffer", "setCurrentJobOffer", "currentRecruiterObservable", "getCurrentRecruiterObservable", "currentUser", "getCurrentUser", "currentUser$delegate", "currentUserId", "getCurrentUserId", "()Ljava/lang/String;", "currentUserId$delegate", "deleteAccountLiveData", "getDeleteAccountLiveData", "deleteAccountLiveData$delegate", "errorText", "getErrorText", "filteredJobOffers", "getFilteredJobOffers", "isRecruitExhausted", "()Z", "setRecruitExhausted", "(Z)V", "isSourceExhausted", "setSourceExhausted", "jobOfferDetailsState", "Lcom/findajob/jobamax/recruiter/profile/jobOffer/create/JobOfferDetailsState;", "getJobOfferDetailsState", "()Lcom/findajob/jobamax/recruiter/profile/jobOffer/create/JobOfferDetailsState;", "setJobOfferDetailsState", "(Lcom/findajob/jobamax/recruiter/profile/jobOffer/create/JobOfferDetailsState;)V", "getJobOfferRepo", "()Lcom/findajob/jobamax/repo/JobOfferRepository;", "setJobOfferRepo", "(Lcom/findajob/jobamax/repo/JobOfferRepository;)V", "jobSeekerLiveData", "getJobSeekerLiveData", "getJobSeekerRepo", "()Lcom/findajob/jobamax/repo/JobSeekerRepo;", "setJobSeekerRepo", "(Lcom/findajob/jobamax/repo/JobSeekerRepo;)V", "jobSeekers", "getJobSeekers", "setJobSeekers", "jobSourceObservable", "getJobSourceObservable", "matchCount", "", "getMatchCount", "()I", "setMatchCount", "(I)V", "matchDailyLimit", "getMatchDailyLimit", "setMatchDailyLimit", "messageRepo", "Lcom/findajob/jobamax/repo/MessageRepository;", "paymentHistoryList", "getPaymentHistoryList", "setPaymentHistoryList", "paymentHistoryLiveData", "recruitIndex", "getRecruitIndex", "setRecruitIndex", "recruitPageIndex", "getRecruitPageIndex", "setRecruitPageIndex", "recruiter", "getRecruiter", "()Lcom/findajob/jobamax/model/Recruiter;", "recruiterParseObject", "getRecruiterParseObject", "setRecruiterParseObject", "getRecruiterRepo", "()Lcom/findajob/jobamax/repo/RecruiterRepo;", "setRecruiterRepo", "(Lcom/findajob/jobamax/repo/RecruiterRepo;)V", "requestQueue", "Lcom/android/volley/RequestQueue;", "getRequestQueue", "()Lcom/android/volley/RequestQueue;", "requestQueue$delegate", "selectedJobOffer", "getSelectedJobOffer", "setSelectedJobOffer", "selectedJobOfferObjectId", "getSelectedJobOfferObjectId", "setSelectedJobOfferObjectId", "(Ljava/lang/String;)V", "selectedJobOfferObservable", "getSelectedJobOfferObservable", "sourceCount", "getSourceCount", "setSourceCount", "sourceDailyLimit", "getSourceDailyLimit", "setSourceDailyLimit", "sourceIndex", "getSourceIndex", "setSourceIndex", "sourcePageIndex", "getSourcePageIndex", "setSourcePageIndex", "unarchiveJobOfferSuccess", "getUnarchiveJobOfferSuccess", "addRejectReason", "", "jobSeeker", "reason", "archiveJobOffer", "jobId", "cancel", "Lkotlinx/coroutines/Job;", "deleteAccount", "reasons", "getAllJobOffersObserver", "getApplicantsObserver", "getCardDetails", "callback", "Lcom/findajob/jobamax/model/GetCardDetailsCallback;", "getCompanyObserver", "getCurrentRecruiter", "getJobOfferById", "getPaymentHistoryObserver", "loadActiveJobOffers", "Lio/reactivex/disposables/Disposable;", "loadApplicants", "loadArchivedJobOffers", "loadJobOffers", "loadJobSeekers", "loadPaymentHistory", "modifyJobSource", "jobSource", "recruit", "refuse", "saveCompany", "Lcom/findajob/jobamax/repo/SaveParseObjectCallback;", "saveCompanyData", "saveJobOffer", "fileUri", "Landroid/net/Uri;", "Lcom/findajob/jobamax/repo/SaveJobOfferCallback;", "saveJobOfferData", "saveJobSource", "Lcom/findajob/jobamax/model/JobSource;", "savePaymentMethod", "paymentMethodId", "Lcom/findajob/jobamax/model/SaveCardDetailsCallback;", "sendMatchNotification", "jobSeekerId", "sendNotification", "notification", "Lorg/json/JSONObject;", "sourceUser", "roleType", "receiverObjectId", "submitData", "personalInfoModel", "Lcom/findajob/jobamax/recruiter/profile/account/personalInfo/RecruiterPersonalInformationModel;", "Lkotlin/Function1;", "Lcom/parse/ParseException;", "Lkotlin/ParameterName;", "name", "it", "unarchiveJobOffer", "undoCancel", "undoJob", "updateCompany", "updateFlag", "flag", "key", "Lcom/findajob/jobamax/model/UpdateUserCallback;", "updateMessagePushNotificationFlag", "updateNewsMatchesPushNotificationFlag", "updateSocialMediaLinks", "socialMedia", "Lcom/findajob/jobamax/recruiter/profile/account/social/RecruiterSocialAccountModel;", "uploadLogo", "logoUri", "app_debug"})
public final class RecruiterHomeViewModel extends com.findajob.jobamax.base.BaseAndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private com.findajob.jobamax.repo.JobSeekerRepo jobSeekerRepo;
    @org.jetbrains.annotations.NotNull()
    private com.findajob.jobamax.repo.JobOfferRepository jobOfferRepo;
    @org.jetbrains.annotations.NotNull()
    private com.findajob.jobamax.repo.RecruiterRepo recruiterRepo;
    @org.jetbrains.annotations.NotNull()
    private android.app.Application context;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _errorText = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> errorText = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<? extends com.parse.ParseObject> allJobOffers;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.parse.ParseObject> jobSeekers;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.parse.ParseObject> applicants;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.parse.ParseObject> paymentHistoryList;
    private int recruitIndex = 0;
    private int sourceIndex = 0;
    private int sourcePageIndex = 0;
    private boolean isSourceExhausted = false;
    private int recruitPageIndex = 0;
    private boolean isRecruitExhausted = false;
    private int matchDailyLimit = 0;
    private int matchCount = 0;
    private int sourceDailyLimit = 0;
    private int sourceCount = 0;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject recruiterParseObject;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject companyParseObject;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.parse.ParseObject>> allJobOffersLiveData = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.parse.ParseObject>> applicantsLiveData = null;
    private final androidx.lifecycle.MutableLiveData<com.findajob.jobamax.model.Company> companyLiveData = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.parse.ParseObject>> _jobSeekerLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.parse.ParseObject>> jobSeekerLiveData = null;
    private androidx.lifecycle.MutableLiveData<java.util.List<com.parse.ParseObject>> paymentHistoryLiveData;
    @org.jetbrains.annotations.NotNull()
    private com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsState jobOfferDetailsState;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject currentJobOffer;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject selectedJobOffer;
    private final com.findajob.jobamax.repo.MessageRepository messageRepo = null;
    private final androidx.lifecycle.MutableLiveData<com.findajob.jobamax.model.JobOffer> _selectedJobOfferObservable = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.findajob.jobamax.model.JobOffer> selectedJobOfferObservable = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedJobOfferObjectId = "";
    private final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.String, java.lang.Boolean>> _archiveJobOfferSuccess = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<kotlin.Pair<java.lang.String, java.lang.Boolean>> archiveJobOfferSuccess = null;
    private final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.String, java.lang.Boolean>> _unarchiveJobOfferSuccess = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<kotlin.Pair<java.lang.String, java.lang.Boolean>> unarchiveJobOfferSuccess = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.parse.ParseObject>> _allJObOffersObservable = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.parse.ParseObject>> allJobOffersObservable = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.parse.ParseObject>> _filteredJobOffers = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.parse.ParseObject>> filteredJobOffers = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.parse.ParseObject>> _activeJObOffersObservable = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.parse.ParseObject>> activeJobOffersObservable = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.parse.ParseObject>> _archivedJObOffersObservable = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.parse.ParseObject>> archivedJobOffersObservable = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _companyDataSaveListener = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> companyDataSaveListener = null;
    private final kotlin.Lazy requestQueue$delegate = null;
    private final androidx.lifecycle.MutableLiveData<com.parse.ParseObject> _jobSourceObservable = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.parse.ParseObject> jobSourceObservable = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy currentUserId$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy currentUser$delegate = null;
    private final androidx.lifecycle.MutableLiveData<com.findajob.jobamax.model.Recruiter> _currentRecruiterObservable = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.findajob.jobamax.model.Recruiter> currentRecruiterObservable = null;
    private final kotlin.Lazy _deleteAccountStatus$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy deleteAccountLiveData$delegate = null;
    
    @javax.inject.Inject()
    public RecruiterHomeViewModel(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.JobSeekerRepo jobSeekerRepo, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.JobOfferRepository jobOfferRepo, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.RecruiterRepo recruiterRepo, @org.jetbrains.annotations.NotNull()
    android.app.Application context) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.repo.JobSeekerRepo getJobSeekerRepo() {
        return null;
    }
    
    public final void setJobSeekerRepo(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.JobSeekerRepo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.repo.JobOfferRepository getJobOfferRepo() {
        return null;
    }
    
    public final void setJobOfferRepo(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.JobOfferRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.repo.RecruiterRepo getRecruiterRepo() {
        return null;
    }
    
    public final void setRecruiterRepo(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.RecruiterRepo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull()
    android.app.Application p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getErrorText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.parse.ParseObject> getAllJobOffers() {
        return null;
    }
    
    public final void setAllJobOffers(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.parse.ParseObject> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.parse.ParseObject> getJobSeekers() {
        return null;
    }
    
    public final void setJobSeekers(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.parse.ParseObject> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.parse.ParseObject> getApplicants() {
        return null;
    }
    
    public final void setApplicants(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.parse.ParseObject> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.parse.ParseObject> getPaymentHistoryList() {
        return null;
    }
    
    public final void setPaymentHistoryList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.parse.ParseObject> p0) {
    }
    
    public final int getRecruitIndex() {
        return 0;
    }
    
    public final void setRecruitIndex(int p0) {
    }
    
    public final int getSourceIndex() {
        return 0;
    }
    
    public final void setSourceIndex(int p0) {
    }
    
    public final int getSourcePageIndex() {
        return 0;
    }
    
    public final void setSourcePageIndex(int p0) {
    }
    
    public final boolean isSourceExhausted() {
        return false;
    }
    
    public final void setSourceExhausted(boolean p0) {
    }
    
    public final int getRecruitPageIndex() {
        return 0;
    }
    
    public final void setRecruitPageIndex(int p0) {
    }
    
    public final boolean isRecruitExhausted() {
        return false;
    }
    
    public final void setRecruitExhausted(boolean p0) {
    }
    
    public final int getMatchDailyLimit() {
        return 0;
    }
    
    public final void setMatchDailyLimit(int p0) {
    }
    
    public final int getMatchCount() {
        return 0;
    }
    
    public final void setMatchCount(int p0) {
    }
    
    public final int getSourceDailyLimit() {
        return 0;
    }
    
    public final void setSourceDailyLimit(int p0) {
    }
    
    public final int getSourceCount() {
        return 0;
    }
    
    public final void setSourceCount(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getRecruiterParseObject() {
        return null;
    }
    
    public final void setRecruiterParseObject(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getCompanyParseObject() {
        return null;
    }
    
    public final void setCompanyParseObject(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.Recruiter getRecruiter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.Company getCompany() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.parse.ParseObject>> getJobSeekerLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.findajob.jobamax.model.Company> getCompanyObserver() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.parse.ParseObject>> getAllJobOffersObserver() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.parse.ParseObject>> getApplicantsObserver() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.parse.ParseObject>> getPaymentHistoryObserver() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsState getJobOfferDetailsState() {
        return null;
    }
    
    public final void setJobOfferDetailsState(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsState p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getCurrentJobOffer() {
        return null;
    }
    
    public final void setCurrentJobOffer(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getSelectedJobOffer() {
        return null;
    }
    
    public final void setSelectedJobOffer(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.findajob.jobamax.model.JobOffer> getSelectedJobOfferObservable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSelectedJobOfferObjectId() {
        return null;
    }
    
    public final void setSelectedJobOfferObjectId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final void getJobOfferById(@org.jetbrains.annotations.NotNull()
    java.lang.String jobId) {
    }
    
    public final void getRecruiter() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<kotlin.Pair<java.lang.String, java.lang.Boolean>> getArchiveJobOfferSuccess() {
        return null;
    }
    
    public final void archiveJobOffer(@org.jetbrains.annotations.NotNull()
    java.lang.String jobId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<kotlin.Pair<java.lang.String, java.lang.Boolean>> getUnarchiveJobOfferSuccess() {
        return null;
    }
    
    public final void unarchiveJobOffer(@org.jetbrains.annotations.NotNull()
    java.lang.String jobId) {
    }
    
    public final void recruit(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject jobSeeker) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job cancel(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject jobSeeker) {
        return null;
    }
    
    public final void undoCancel(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject jobSeeker) {
    }
    
    public final void refuse(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject jobSeeker) {
    }
    
    public final void undoJob(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject jobSeeker) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.parse.ParseObject>> getAllJobOffersObservable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.disposables.Disposable loadJobOffers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.parse.ParseObject>> getFilteredJobOffers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.parse.ParseObject>> getActiveJobOffersObservable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.disposables.Disposable loadActiveJobOffers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.parse.ParseObject>> getArchivedJobOffersObservable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.disposables.Disposable loadArchivedJobOffers() {
        return null;
    }
    
    public final void loadApplicants() {
    }
    
    public final void addRejectReason(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject jobSeeker, @org.jetbrains.annotations.NotNull()
    java.lang.String reason) {
    }
    
    public final void loadJobSeekers() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job saveJobSource(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.JobSource jobSource) {
        return null;
    }
    
    public final void saveJobOffer(@org.jetbrains.annotations.Nullable()
    android.net.Uri fileUri, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.SaveJobOfferCallback callback) {
    }
    
    public final void updateFlag(boolean flag, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.UpdateUserCallback callback) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updateMessagePushNotificationFlag(boolean flag) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updateNewsMatchesPushNotificationFlag(boolean flag) {
        return null;
    }
    
    public final void submitData(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationModel personalInfoModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void saveCompany(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.Company company, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.SaveParseObjectCallback callback) {
    }
    
    public final void updateCompany(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.Company company, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.SaveParseObjectCallback callback) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getCompanyDataSaveListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job saveCompanyData(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.Company company) {
        return null;
    }
    
    public final void updateSocialMediaLinks(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.recruiter.profile.account.social.RecruiterSocialAccountModel socialMedia, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    private final void saveJobOfferData(com.findajob.jobamax.repo.SaveJobOfferCallback callback) {
    }
    
    private final void sendMatchNotification(java.lang.String jobSeekerId) {
    }
    
    private final com.android.volley.RequestQueue getRequestQueue() {
        return null;
    }
    
    private final void sendNotification(org.json.JSONObject notification) {
    }
    
    public final void uploadLogo(@org.jetbrains.annotations.NotNull()
    android.net.Uri logoUri, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.SaveParseObjectCallback callback) {
    }
    
    public final void savePaymentMethod(@org.jetbrains.annotations.NotNull()
    java.lang.String paymentMethodId, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.SaveCardDetailsCallback callback) {
    }
    
    public final void getCardDetails(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.GetCardDetailsCallback callback) {
    }
    
    public final void loadPaymentHistory() {
    }
    
    public final void sourceUser(@org.jetbrains.annotations.NotNull()
    java.lang.String roleType, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverObjectId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.parse.ParseObject> getJobSourceObservable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job modifyJobSource(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject jobSource) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentUserId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.parse.ParseObject getCurrentUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.findajob.jobamax.model.Recruiter> getCurrentRecruiterObservable() {
        return null;
    }
    
    public final void getCurrentRecruiter() {
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
}