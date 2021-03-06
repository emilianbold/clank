/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.clang.analysis.analyses.threadSafety.til;

import org.clank.support.*;


// Base class for simple reducers that don't much care about the context.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleReducerBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 97,
 FQN="clang::threadSafety::til::SimpleReducerBase", NM="_ZN5clang12threadSafety3til17SimpleReducerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til17SimpleReducerBaseE")
//</editor-fold>
public class SimpleReducerBase {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleReducerBase::TraversalKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 99,
   FQN="clang::threadSafety::til::SimpleReducerBase::TraversalKind", NM="_ZN5clang12threadSafety3til17SimpleReducerBase13TraversalKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til17SimpleReducerBase13TraversalKindE")
  //</editor-fold>
  public enum TraversalKind implements Native.ComparableLower {
    TRV_Normal(0), // ordinary subexpressions
    TRV_Decl(TRV_Normal.getValue() + 1), // declarations (e.g. function bodies)
    TRV_Lazy(TRV_Decl.getValue() + 1), // expressions that require lazy evaluation
    TRV_Type(TRV_Lazy.getValue() + 1); // type expressions

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TraversalKind valueOf(int val) {
      TraversalKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final TraversalKind[] VALUES;
      private static final TraversalKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TraversalKind kind : TraversalKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TraversalKind[min < 0 ? (1-min) : 0];
        VALUES = new TraversalKind[max >= 0 ? (1+max) : 0];
        for (TraversalKind kind : TraversalKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private TraversalKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TraversalKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TraversalKind)obj).value);}
    //</editor-fold>
  };
  
  // R_Ctx defines a "context" for the traversal, which encodes information
  // about where a term appears.  This can be used to encoding the
  // "current continuation" for CPS transforms, or other information.
  /*typedef TraversalKind R_Ctx*/
//  public final class R_Ctx extends TraversalKind{ };
  
  // Create context for an ordinary subexpression.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleReducerBase::subExprCtx">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 112,
   FQN="clang::threadSafety::til::SimpleReducerBase::subExprCtx", NM="_ZN5clang12threadSafety3til17SimpleReducerBase10subExprCtxENS2_13TraversalKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til17SimpleReducerBase10subExprCtxENS2_13TraversalKindE")
  //</editor-fold>
  public TraversalKind subExprCtx(TraversalKind Ctx) {
    return TraversalKind.TRV_Normal;
  }

  
  // Create context for a subexpression that occurs in a declaration position
  // (e.g. function body).
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleReducerBase::declCtx">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 116,
   FQN="clang::threadSafety::til::SimpleReducerBase::declCtx", NM="_ZN5clang12threadSafety3til17SimpleReducerBase7declCtxENS2_13TraversalKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til17SimpleReducerBase7declCtxENS2_13TraversalKindE")
  //</editor-fold>
  public TraversalKind declCtx(TraversalKind Ctx) {
    return TraversalKind.TRV_Decl;
  }

  
  // Create context for a subexpression that occurs in a position that
  // should be reduced lazily.  (e.g. code body).
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleReducerBase::lazyCtx">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 120,
   FQN="clang::threadSafety::til::SimpleReducerBase::lazyCtx", NM="_ZN5clang12threadSafety3til17SimpleReducerBase7lazyCtxENS2_13TraversalKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til17SimpleReducerBase7lazyCtxENS2_13TraversalKindE")
  //</editor-fold>
  public TraversalKind lazyCtx(TraversalKind Ctx) {
    return TraversalKind.TRV_Lazy;
  }

  
  // Create context for a subexpression that occurs in a type position.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleReducerBase::typeCtx">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 123,
   FQN="clang::threadSafety::til::SimpleReducerBase::typeCtx", NM="_ZN5clang12threadSafety3til17SimpleReducerBase7typeCtxENS2_13TraversalKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til17SimpleReducerBase7typeCtxENS2_13TraversalKindE")
  //</editor-fold>
  public TraversalKind typeCtx(TraversalKind Ctx) {
    return TraversalKind.TRV_Type;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleReducerBase::SimpleReducerBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 97,
   FQN="clang::threadSafety::til::SimpleReducerBase::SimpleReducerBase", NM="_ZN5clang12threadSafety3til17SimpleReducerBaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til17SimpleReducerBaseC1Ev")
  //</editor-fold>
  public /*inline*/ SimpleReducerBase() {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
