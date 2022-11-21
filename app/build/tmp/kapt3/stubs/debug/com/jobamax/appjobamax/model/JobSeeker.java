package com.jobamax.appjobamax.model;

import com.google.gson.Gson;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;
import kotlin.collections.ArrayList;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u00aa\u00022\u00020\u0001:\u0002\u00aa\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u0007\b\u0016\u00a2\u0006\u0002\u0010\bJ$\u0010\u00a2\u0002\u001a\u0012\u0012\u0004\u0012\u00020>0%j\b\u0012\u0004\u0012\u00020>`&2\t\u0010\u00a3\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J$\u0010\u00a4\u0002\u001a\u0012\u0012\u0004\u0012\u00020Q0%j\b\u0012\u0004\u0012\u00020Q`&2\t\u0010\u00a3\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J$\u0010\u00a5\u0002\u001a\u0012\u0012\u0004\u0012\u00020h0%j\b\u0012\u0004\u0012\u00020h`&2\t\u0010\u00a3\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J\u0015\u0010\u00a6\u0002\u001a\u00030\u00b0\u00012\t\u0010\u00a3\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J$\u0010\u00a7\u0002\u001a\u0012\u0012\u0004\u0012\u00020\n0%j\b\u0012\u0004\u0012\u00020\n`&2\t\u0010\u00a3\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J&\u0010\u00a8\u0002\u001a\u0014\u0012\u0005\u0012\u00030\u009c\u00020%j\t\u0012\u0005\u0012\u00030\u009c\u0002`&2\t\u0010\u00a3\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010i\u001a\u00020\nH\u0002J\t\u0010\u0081\u0002\u001a\u00020\nH\u0002J\u0007\u0010\u00a9\u0002\u001a\u00020\u0006R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR*\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\n0%j\b\u0012\u0004\u0012\u00020\n`&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0012\"\u0004\b3\u0010\u0014R\u001a\u00104\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\f\"\u0004\b6\u0010\u000eR\u001a\u00107\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\f\"\u0004\b9\u0010\u000eR\u001a\u0010:\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\f\"\u0004\b<\u0010\u000eR*\u0010=\u001a\u0012\u0012\u0004\u0012\u00020>0%j\b\u0012\u0004\u0012\u00020>`&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010(\"\u0004\b@\u0010*R\u001a\u0010A\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\f\"\u0004\bC\u0010\u000eR\u001a\u0010D\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\f\"\u0004\bF\u0010\u000eR\u001a\u0010G\u001a\u00020,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010.\"\u0004\bI\u00100R \u0010J\u001a\b\u0012\u0004\u0012\u00020\n0KX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR*\u0010P\u001a\u0012\u0012\u0004\u0012\u00020Q0%j\b\u0012\u0004\u0012\u00020Q`&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010(\"\u0004\bS\u0010*R\u001a\u0010T\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\f\"\u0004\bV\u0010\u000eR\u001a\u0010W\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\f\"\u0004\bY\u0010\u000eR\u001c\u0010Z\u001a\u0004\u0018\u00010[X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001a\u0010`\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\f\"\u0004\bb\u0010\u000eR\u0011\u0010c\u001a\u00020d\u00a2\u0006\b\n\u0000\u001a\u0004\be\u0010fR*\u0010g\u001a\u0012\u0012\u0004\u0012\u00020h0%j\b\u0012\u0004\u0012\u00020h`&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010(\"\u0004\bj\u0010*R\u001a\u0010k\u001a\u00020,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u0010.\"\u0004\bm\u00100R\u001a\u0010n\u001a\u00020,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u0010.\"\u0004\bp\u00100R\u001c\u0010q\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010\u0007R*\u0010u\u001a\u0012\u0012\u0004\u0012\u00020\n0%j\b\u0012\u0004\u0012\u00020\n`&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bv\u0010(\"\u0004\bw\u0010*R\u001a\u0010x\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\by\u0010\f\"\u0004\bz\u0010\u000eR \u0010{\u001a\b\u0012\u0004\u0012\u00020\n0KX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b|\u0010M\"\u0004\b}\u0010OR!\u0010~\u001a\b\u0012\u0004\u0012\u00020\n0KX\u0086\u000e\u00a2\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010M\"\u0005\b\u0080\u0001\u0010OR\u001d\u0010\u0081\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010\f\"\u0005\b\u0083\u0001\u0010\u000eR\u001d\u0010\u0084\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010\f\"\u0005\b\u0086\u0001\u0010\u000eR\u001d\u0010\u0087\u0001\u001a\u00020,X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010.\"\u0005\b\u0088\u0001\u00100R\u001d\u0010\u0089\u0001\u001a\u00020,X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010.\"\u0005\b\u008a\u0001\u00100R\u001d\u0010\u008b\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010\f\"\u0005\b\u008d\u0001\u0010\u000eR#\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020\n0KX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010M\"\u0005\b\u0090\u0001\u0010OR\u001d\u0010\u0091\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010\f\"\u0005\b\u0093\u0001\u0010\u000eR\u001d\u0010\u0094\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010\f\"\u0005\b\u0096\u0001\u0010\u000eR\u001d\u0010\u0097\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010\f\"\u0005\b\u0099\u0001\u0010\u000eR\u001d\u0010\u009a\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010\f\"\u0005\b\u009c\u0001\u0010\u000eR \u0010\u009d\u0001\u001a\u00030\u009e\u0001X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u009f\u0001\u0010\u00a0\u0001\"\u0006\b\u00a1\u0001\u0010\u00a2\u0001R\u001d\u0010\u00a3\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a4\u0001\u0010\f\"\u0005\b\u00a5\u0001\u0010\u000eR \u0010\u00a6\u0001\u001a\u00030\u009e\u0001X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00a7\u0001\u0010\u00a0\u0001\"\u0006\b\u00a8\u0001\u0010\u00a2\u0001R\u001d\u0010\u00a9\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00aa\u0001\u0010\f\"\u0005\b\u00ab\u0001\u0010\u000eR\u001d\u0010\u00ac\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ad\u0001\u0010\f\"\u0005\b\u00ae\u0001\u0010\u000eR\"\u0010\u00af\u0001\u001a\u0005\u0018\u00010\u00b0\u0001X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00b1\u0001\u0010\u00b2\u0001\"\u0006\b\u00b3\u0001\u0010\u00b4\u0001R\u001d\u0010\u00b5\u0001\u001a\u00020,X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b6\u0001\u0010.\"\u0005\b\u00b7\u0001\u00100R\u001d\u0010\u00b8\u0001\u001a\u00020,X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b9\u0001\u0010.\"\u0005\b\u00ba\u0001\u00100R\u001d\u0010\u00bb\u0001\u001a\u00020,X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00bc\u0001\u0010.\"\u0005\b\u00bd\u0001\u00100R\u001d\u0010\u00be\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00bf\u0001\u0010\f\"\u0005\b\u00c0\u0001\u0010\u000eR\u001d\u0010\u00c1\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c2\u0001\u0010\f\"\u0005\b\u00c3\u0001\u0010\u000eR\u001f\u0010\u00c4\u0001\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c5\u0001\u0010s\"\u0005\b\u00c6\u0001\u0010\u0007R\u001d\u0010\u00c7\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c8\u0001\u0010\f\"\u0005\b\u00c9\u0001\u0010\u000eR\u001f\u0010\u00ca\u0001\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00cb\u0001\u0010s\"\u0005\b\u00cc\u0001\u0010\u0007R#\u0010\u00cd\u0001\u001a\b\u0012\u0004\u0012\u00020\n0KX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ce\u0001\u0010M\"\u0005\b\u00cf\u0001\u0010OR#\u0010\u00d0\u0001\u001a\b\u0012\u0004\u0012\u00020\n0KX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d1\u0001\u0010M\"\u0005\b\u00d2\u0001\u0010OR\u001d\u0010\u00d3\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d4\u0001\u0010\f\"\u0005\b\u00d5\u0001\u0010\u000eR\u001d\u0010\u00d6\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d7\u0001\u0010\f\"\u0005\b\u00d8\u0001\u0010\u000eR\u001d\u0010\u00d9\u0001\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00da\u0001\u0010\u0012\"\u0005\b\u00db\u0001\u0010\u0014R\u001d\u0010\u00dc\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00dd\u0001\u0010\f\"\u0005\b\u00de\u0001\u0010\u000eR\u001d\u0010\u00df\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00e0\u0001\u0010\f\"\u0005\b\u00e1\u0001\u0010\u000eR\u001d\u0010\u00e2\u0001\u001a\u00020,X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00e3\u0001\u0010.\"\u0005\b\u00e4\u0001\u00100R\u001d\u0010\u00e5\u0001\u001a\u00020,X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00e6\u0001\u0010.\"\u0005\b\u00e7\u0001\u00100R\"\u0010\u00e8\u0001\u001a\u0005\u0018\u00010\u00e9\u0001X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00ea\u0001\u0010\u00eb\u0001\"\u0006\b\u00ec\u0001\u0010\u00ed\u0001R\u001d\u0010\u00ee\u0001\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ef\u0001\u0010\u0012\"\u0005\b\u00f0\u0001\u0010\u0014R\u001d\u0010\u00f1\u0001\u001a\u00020,X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00f2\u0001\u0010.\"\u0005\b\u00f3\u0001\u00100R\u001d\u0010\u00f4\u0001\u001a\u00020,X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00f5\u0001\u0010.\"\u0005\b\u00f6\u0001\u00100R\u001d\u0010\u00f7\u0001\u001a\u00020,X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00f8\u0001\u0010.\"\u0005\b\u00f9\u0001\u00100R\u001d\u0010\u00fa\u0001\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00fb\u0001\u0010\f\"\u0005\b\u00fc\u0001\u0010\u000eR#\u0010\u00fd\u0001\u001a\b\u0012\u0004\u0012\u00020\n0KX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00fe\u0001\u0010M\"\u0005\b\u00ff\u0001\u0010OR-\u0010\u0080\u0002\u001a\u0012\u0012\u0004\u0012\u00020\n0%j\b\u0012\u0004\u0012\u00020\n`&X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0002\u0010(\"\u0005\b\u0082\u0002\u0010*R\u001d\u0010\u0083\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0002\u0010\f\"\u0005\b\u0085\u0002\u0010\u000eR\u001d\u0010\u0086\u0002\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0002\u0010\u0012\"\u0005\b\u0088\u0002\u0010\u0014R\u001d\u0010\u0089\u0002\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0002\u0010\u0012\"\u0005\b\u008b\u0002\u0010\u0014R#\u0010\u008c\u0002\u001a\b\u0012\u0004\u0012\u00020\n0KX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0002\u0010M\"\u0005\b\u008e\u0002\u0010OR\u001d\u0010\u008f\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0002\u0010\f\"\u0005\b\u0091\u0002\u0010\u000eR\u001d\u0010\u0092\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0002\u0010\f\"\u0005\b\u0094\u0002\u0010\u000eR\u001f\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0002\u0010s\"\u0005\b\u0097\u0002\u0010\u0007R\u001d\u0010\u0098\u0002\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0002\u0010\f\"\u0005\b\u009a\u0002\u0010\u000eR/\u0010\u009b\u0002\u001a\u0014\u0012\u0005\u0012\u00030\u009c\u00020%j\t\u0012\u0005\u0012\u00030\u009c\u0002`&X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0002\u0010(\"\u0005\b\u009e\u0002\u0010*R#\u0010\u009f\u0002\u001a\b\u0012\u0004\u0012\u00020\n0KX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a0\u0002\u0010M\"\u0005\b\u00a1\u0002\u0010O\u00a8\u0006\u00ab\u0002"}, d2 = {"Lcom/jobamax/appjobamax/model/JobSeeker;", "", "user", "Lcom/jobamax/appjobamax/model/User;", "(Lcom/jobamax/appjobamax/model/User;)V", "obj", "Lcom/parse/ParseObject;", "(Lcom/parse/ParseObject;)V", "()V", "aboutMe", "", "getAboutMe", "()Ljava/lang/String;", "setAboutMe", "(Ljava/lang/String;)V", "accountType", "", "getAccountType", "()I", "setAccountType", "(I)V", "activities", "getActivities", "setActivities", "age", "getAge", "setAge", "ageInt", "getAgeInt", "setAgeInt", "attachmentCVLink", "getAttachmentCVLink", "setAttachmentCVLink", "city", "getCity", "setCity", "companyNames", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCompanyNames", "()Ljava/util/ArrayList;", "setCompanyNames", "(Ljava/util/ArrayList;)V", "disableAccountFlag", "", "getDisableAccountFlag", "()Z", "setDisableAccountFlag", "(Z)V", "distance", "getDistance", "setDistance", "dob", "getDob", "setDob", "documentName", "getDocumentName", "setDocumentName", "documentUrl", "getDocumentUrl", "setDocumentUrl", "educations", "Lcom/jobamax/appjobamax/model/Education;", "getEducations", "setEducations", "elevatorPitch", "getElevatorPitch", "setElevatorPitch", "email", "getEmail", "setEmail", "emailVerified", "getEmailVerified", "setEmailVerified", "experience", "", "getExperience", "()Ljava/util/List;", "setExperience", "(Ljava/util/List;)V", "experiences", "Lcom/jobamax/appjobamax/model/Experience;", "getExperiences", "setExperiences", "firstName", "getFirstName", "setFirstName", "gender", "getGender", "setGender", "geoLocation", "Lcom/parse/ParseGeoPoint;", "getGeoLocation", "()Lcom/parse/ParseGeoPoint;", "setGeoLocation", "(Lcom/parse/ParseGeoPoint;)V", "gotReferralCode", "getGotReferralCode", "setGotReferralCode", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "hardSkills", "Lcom/jobamax/appjobamax/model/HardSkill;", "getHardSkills", "setHardSkills", "hideAccount", "getHideAccount", "setHideAccount", "hideMeFlag", "getHideMeFlag", "setHideMeFlag", "idealJob", "getIdealJob", "()Lcom/parse/ParseObject;", "setIdealJob", "images", "getImages", "setImages", "instagramLink", "getInstagramLink", "setInstagramLink", "interestedIn", "getInterestedIn", "setInterestedIn", "interests", "getInterests", "setInterests", "introAudioUrl", "getIntroAudioUrl", "setIntroAudioUrl", "introVideoUrl", "getIntroVideoUrl", "setIntroVideoUrl", "isNetworkingHandRaised", "setNetworkingHandRaised", "isNetworkingMuted", "setNetworkingMuted", "job", "getJob", "setJob", "jobCategory", "getJobCategory", "setJobCategory", "jobLocation", "getJobLocation", "setJobLocation", "jobSeekerId", "getJobSeekerId", "setJobSeekerId", "lastName", "getLastName", "setLastName", "lastTodayReachUpdatedAt", "getLastTodayReachUpdatedAt", "setLastTodayReachUpdatedAt", "lat", "", "getLat", "()D", "setLat", "(D)V", "linkedInLink", "getLinkedInLink", "setLinkedInLink", "lng", "getLng", "setLng", "location", "getLocation", "setLocation", "loginType", "getLoginType", "setLoginType", "manualCriteria", "Lcom/jobamax/appjobamax/model/ManualCriteria;", "getManualCriteria", "()Lcom/jobamax/appjobamax/model/ManualCriteria;", "setManualCriteria", "(Lcom/jobamax/appjobamax/model/ManualCriteria;)V", "messagePNFlag", "getMessagePNFlag", "setMessagePNFlag", "newMatchPNFlag", "getNewMatchPNFlag", "setNewMatchPNFlag", "newsLetterPNFlag", "getNewsLetterPNFlag", "setNewsLetterPNFlag", "password", "getPassword", "setPassword", "personalPresentationLink", "getPersonalPresentationLink", "setPersonalPresentationLink", "pfObject", "getPfObject", "setPfObject", "phoneNumber", "getPhoneNumber", "setPhoneNumber", "portfolio", "getPortfolio", "setPortfolio", "portfolioDocLinks", "getPortfolioDocLinks", "setPortfolioDocLinks", "portfolioLinks", "getPortfolioLinks", "setPortfolioLinks", "postCode", "getPostCode", "setPostCode", "profession", "getProfession", "setProfession", "profilePercentage", "getProfilePercentage", "setProfilePercentage", "profilePicUrl", "getProfilePicUrl", "setProfilePicUrl", "promoCode", "getPromoCode", "setPromoCode", "readReceiptFlag", "getReadReceiptFlag", "setReadReceiptFlag", "receiveNewsletter", "getReceiveNewsletter", "setReceiveNewsletter", "roomExpiryDate", "Ljava/util/Date;", "getRoomExpiryDate", "()Ljava/util/Date;", "setRoomExpiryDate", "(Ljava/util/Date;)V", "roomId", "getRoomId", "setRoomId", "seenOnboarding", "getSeenOnboarding", "setSeenOnboarding", "seenSwipeTutorial", "getSeenSwipeTutorial", "setSeenSwipeTutorial", "seenUpdatePopup", "getSeenUpdatePopup", "setSeenUpdatePopup", "skills", "getSkills", "setSkills", "socialAccounts", "getSocialAccounts", "setSocialAccounts", "softSkills", "getSoftSkills", "setSoftSkills", "tikTokLink", "getTikTokLink", "setTikTokLink", "todayReach", "getTodayReach", "setTodayReach", "totalReach", "getTotalReach", "setTotalReach", "typeOfWork", "getTypeOfWork", "setTypeOfWork", "university", "getUniversity", "setUniversity", "userId", "getUserId", "setUserId", "userObj", "getUserObj", "setUserObj", "videoThumbnailUrl", "getVideoThumbnailUrl", "setVideoThumbnailUrl", "volunteerings", "Lcom/jobamax/appjobamax/model/Volunteering;", "getVolunteerings", "setVolunteerings", "workspaces", "getWorkspaces", "setWorkspaces", "convertStringToEducations", "any", "convertStringToExperiences", "convertStringToHardSkills", "convertStringToManualCriteria", "convertStringToSoftSkills", "convertStringToVolunteerings", "toParseObject", "Companion", "app_debug"})
public final class JobSeeker {
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String jobSeekerId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String userId = "";
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject userObj;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String gender = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String firstName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String lastName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String university = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String loginType = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String profilePicUrl = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String introVideoUrl = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String introAudioUrl = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String postCode = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String promoCode = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String dob = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String email = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String phoneNumber = "";
    private boolean readReceiptFlag = false;
    private boolean hideAccount = false;
    private boolean newMatchPNFlag = false;
    private boolean messagePNFlag = false;
    private boolean newsLetterPNFlag = false;
    private boolean receiveNewsletter = false;
    private boolean isNetworkingMuted = false;
    private boolean isNetworkingHandRaised = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String personalPresentationLink = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String attachmentCVLink = "";
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject portfolio;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject idealJob;
    private boolean hideMeFlag = false;
    private boolean seenOnboarding = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String job = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String location = "";
    private int accountType = 0;
    private int distance = 0;
    private double lat = 0.0;
    private double lng = 0.0;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> typeOfWork;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> jobCategory;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> experience;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> socialAccounts;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> images;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> portfolioLinks;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> portfolioDocLinks;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String documentUrl = "";
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.model.ManualCriteria manualCriteria;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.Education> educations;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.Experience> experiences;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.Volunteering> volunteerings;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String skills = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.HardSkill> hardSkills;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> softSkills;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> companyNames;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String jobLocation = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String city = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> interestedIn;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String age = "";
    private int ageInt = -1;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> workspaces;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String activities = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> interests;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String instagramLink = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String linkedInLink = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String tikTokLink = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String aboutMe = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String profession = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String elevatorPitch = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String documentName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String videoThumbnailUrl = "";
    private boolean disableAccountFlag = false;
    private int totalReach = 0;
    private int todayReach = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String lastTodayReachUpdatedAt = "";
    private int roomId = 0;
    @org.jetbrains.annotations.Nullable()
    private java.util.Date roomExpiryDate;
    private boolean emailVerified = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String password = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String gotReferralCode = "";
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseGeoPoint geoLocation;
    private boolean seenUpdatePopup = true;
    private int profilePercentage = 0;
    private boolean seenSwipeTutorial = false;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject pfObject;
    @org.jetbrains.annotations.NotNull()
    public static final com.jobamax.appjobamax.model.JobSeeker.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CLASS_NAME = "JobSeeker";
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson getGson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJobSeekerId() {
        return null;
    }
    
    public final void setJobSeekerId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserId() {
        return null;
    }
    
    public final void setUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getUserObj() {
        return null;
    }
    
    public final void setUserObj(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGender() {
        return null;
    }
    
    public final void setGender(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstName() {
        return null;
    }
    
    public final void setFirstName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLastName() {
        return null;
    }
    
    public final void setLastName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUniversity() {
        return null;
    }
    
    public final void setUniversity(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLoginType() {
        return null;
    }
    
    public final void setLoginType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProfilePicUrl() {
        return null;
    }
    
    public final void setProfilePicUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIntroVideoUrl() {
        return null;
    }
    
    public final void setIntroVideoUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIntroAudioUrl() {
        return null;
    }
    
    public final void setIntroAudioUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPostCode() {
        return null;
    }
    
    public final void setPostCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPromoCode() {
        return null;
    }
    
    public final void setPromoCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDob() {
        return null;
    }
    
    public final void setDob(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmail() {
        return null;
    }
    
    public final void setEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPhoneNumber() {
        return null;
    }
    
    public final void setPhoneNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getReadReceiptFlag() {
        return false;
    }
    
    public final void setReadReceiptFlag(boolean p0) {
    }
    
    public final boolean getHideAccount() {
        return false;
    }
    
    public final void setHideAccount(boolean p0) {
    }
    
    public final boolean getNewMatchPNFlag() {
        return false;
    }
    
    public final void setNewMatchPNFlag(boolean p0) {
    }
    
    public final boolean getMessagePNFlag() {
        return false;
    }
    
    public final void setMessagePNFlag(boolean p0) {
    }
    
    public final boolean getNewsLetterPNFlag() {
        return false;
    }
    
    public final void setNewsLetterPNFlag(boolean p0) {
    }
    
    public final boolean getReceiveNewsletter() {
        return false;
    }
    
    public final void setReceiveNewsletter(boolean p0) {
    }
    
    public final boolean isNetworkingMuted() {
        return false;
    }
    
    public final void setNetworkingMuted(boolean p0) {
    }
    
    public final boolean isNetworkingHandRaised() {
        return false;
    }
    
    public final void setNetworkingHandRaised(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPersonalPresentationLink() {
        return null;
    }
    
    public final void setPersonalPresentationLink(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAttachmentCVLink() {
        return null;
    }
    
    public final void setAttachmentCVLink(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getPortfolio() {
        return null;
    }
    
    public final void setPortfolio(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getIdealJob() {
        return null;
    }
    
    public final void setIdealJob(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    public final boolean getHideMeFlag() {
        return false;
    }
    
    public final void setHideMeFlag(boolean p0) {
    }
    
    public final boolean getSeenOnboarding() {
        return false;
    }
    
    public final void setSeenOnboarding(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJob() {
        return null;
    }
    
    public final void setJob(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLocation() {
        return null;
    }
    
    public final void setLocation(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getAccountType() {
        return 0;
    }
    
    public final void setAccountType(int p0) {
    }
    
    public final int getDistance() {
        return 0;
    }
    
    public final void setDistance(int p0) {
    }
    
    public final double getLat() {
        return 0.0;
    }
    
    public final void setLat(double p0) {
    }
    
    public final double getLng() {
        return 0.0;
    }
    
    public final void setLng(double p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTypeOfWork() {
        return null;
    }
    
    public final void setTypeOfWork(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getJobCategory() {
        return null;
    }
    
    public final void setJobCategory(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getExperience() {
        return null;
    }
    
    public final void setExperience(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getSocialAccounts() {
        return null;
    }
    
    public final void setSocialAccounts(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getImages() {
        return null;
    }
    
    public final void setImages(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getPortfolioLinks() {
        return null;
    }
    
    public final void setPortfolioLinks(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getPortfolioDocLinks() {
        return null;
    }
    
    public final void setPortfolioDocLinks(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDocumentUrl() {
        return null;
    }
    
    public final void setDocumentUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.model.ManualCriteria getManualCriteria() {
        return null;
    }
    
    public final void setManualCriteria(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.model.ManualCriteria p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.Education> getEducations() {
        return null;
    }
    
    public final void setEducations(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.Education> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.Experience> getExperiences() {
        return null;
    }
    
    public final void setExperiences(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.Experience> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.Volunteering> getVolunteerings() {
        return null;
    }
    
    public final void setVolunteerings(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.Volunteering> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSkills() {
        return null;
    }
    
    public final void setSkills(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.HardSkill> getHardSkills() {
        return null;
    }
    
    public final void setHardSkills(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.HardSkill> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getSoftSkills() {
        return null;
    }
    
    public final void setSoftSkills(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getCompanyNames() {
        return null;
    }
    
    public final void setCompanyNames(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getJobLocation() {
        return null;
    }
    
    public final void setJobLocation(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCity() {
        return null;
    }
    
    public final void setCity(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getInterestedIn() {
        return null;
    }
    
    public final void setInterestedIn(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAge() {
        return null;
    }
    
    public final void setAge(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getAgeInt() {
        return 0;
    }
    
    public final void setAgeInt(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getWorkspaces() {
        return null;
    }
    
    public final void setWorkspaces(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getActivities() {
        return null;
    }
    
    public final void setActivities(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getInterests() {
        return null;
    }
    
    public final void setInterests(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getInstagramLink() {
        return null;
    }
    
    public final void setInstagramLink(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLinkedInLink() {
        return null;
    }
    
    public final void setLinkedInLink(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTikTokLink() {
        return null;
    }
    
    public final void setTikTokLink(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAboutMe() {
        return null;
    }
    
    public final void setAboutMe(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProfession() {
        return null;
    }
    
    public final void setProfession(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getElevatorPitch() {
        return null;
    }
    
    public final void setElevatorPitch(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDocumentName() {
        return null;
    }
    
    public final void setDocumentName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVideoThumbnailUrl() {
        return null;
    }
    
    public final void setVideoThumbnailUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getDisableAccountFlag() {
        return false;
    }
    
    public final void setDisableAccountFlag(boolean p0) {
    }
    
    public final int getTotalReach() {
        return 0;
    }
    
    public final void setTotalReach(int p0) {
    }
    
    public final int getTodayReach() {
        return 0;
    }
    
    public final void setTodayReach(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLastTodayReachUpdatedAt() {
        return null;
    }
    
    public final void setLastTodayReachUpdatedAt(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getRoomId() {
        return 0;
    }
    
    public final void setRoomId(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date getRoomExpiryDate() {
        return null;
    }
    
    public final void setRoomExpiryDate(@org.jetbrains.annotations.Nullable()
    java.util.Date p0) {
    }
    
    public final boolean getEmailVerified() {
        return false;
    }
    
    public final void setEmailVerified(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPassword() {
        return null;
    }
    
    public final void setPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGotReferralCode() {
        return null;
    }
    
    public final void setGotReferralCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseGeoPoint getGeoLocation() {
        return null;
    }
    
    public final void setGeoLocation(@org.jetbrains.annotations.Nullable()
    com.parse.ParseGeoPoint p0) {
    }
    
    public final boolean getSeenUpdatePopup() {
        return false;
    }
    
    public final void setSeenUpdatePopup(boolean p0) {
    }
    
    public final int getProfilePercentage() {
        return 0;
    }
    
    public final void setProfilePercentage(int p0) {
    }
    
    public final boolean getSeenSwipeTutorial() {
        return false;
    }
    
    public final void setSeenSwipeTutorial(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getPfObject() {
        return null;
    }
    
    public final void setPfObject(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.parse.ParseObject toParseObject() {
        return null;
    }
    
    private final java.lang.String getSoftSkills() {
        return null;
    }
    
    private final java.lang.String getHardSkills() {
        return null;
    }
    
    public JobSeeker(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.User user) {
        super();
    }
    
    public JobSeeker(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject obj) {
        super();
    }
    
    private final com.jobamax.appjobamax.model.ManualCriteria convertStringToManualCriteria(java.lang.Object any) {
        return null;
    }
    
    private final java.util.ArrayList<java.lang.String> convertStringToSoftSkills(java.lang.Object any) {
        return null;
    }
    
    private final java.util.ArrayList<com.jobamax.appjobamax.model.HardSkill> convertStringToHardSkills(java.lang.Object any) {
        return null;
    }
    
    private final java.util.ArrayList<com.jobamax.appjobamax.model.Volunteering> convertStringToVolunteerings(java.lang.Object any) {
        return null;
    }
    
    private final java.util.ArrayList<com.jobamax.appjobamax.model.Experience> convertStringToExperiences(java.lang.Object any) {
        return null;
    }
    
    private final java.util.ArrayList<com.jobamax.appjobamax.model.Education> convertStringToEducations(java.lang.Object any) {
        return null;
    }
    
    public JobSeeker() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/jobamax/appjobamax/model/JobSeeker$Companion;", "", "()V", "CLASS_NAME", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}