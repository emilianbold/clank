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

package org.llvm.support.yaml;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;

//<editor-fold defaultstate="collapsed" desc="llvm::yaml::ScalarTraits<Hex64>">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1231,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1201,
 FQN="llvm::yaml::ScalarTraits<Hex64>", NM="_ZN4llvm4yaml12ScalarTraitsINS0_5Hex64EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml12ScalarTraitsINS0_5Hex64EEE")
//</editor-fold>
public class/*struct*/ ScalarTraitsHex64 implements ScalarTraits<Hex64> {
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::ScalarTraits<Hex64>::output">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 982,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 961,
   FQN="llvm::yaml::ScalarTraits<Hex64>::output", NM="_ZN4llvm4yaml12ScalarTraitsINS0_5Hex64EE6outputERKS2_PvRNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml12ScalarTraitsINS0_5Hex64EE6outputERKS2_PvRNS_11raw_ostreamE")
  //</editor-fold>
  public void output(final /*const*/ Hex64 /*&*/ Val, Object/*void P*/ $Prm1, final raw_ostream /*&*/ Out) {
    long/*uint64_t*/ Num = Val.$ulong$ref$C().$deref();
    Out.$out(format(/*KEEP_STR*/"0x%016llX", Num));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::ScalarTraits<Hex64>::input">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", line = 987,
   old_source = "${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp", old_line = 966,
   FQN="llvm::yaml::ScalarTraits<Hex64>::input", NM="_ZN4llvm4yaml12ScalarTraitsINS0_5Hex64EE5inputENS_9StringRefEPvRS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml12ScalarTraitsINS0_5Hex64EE5inputENS_9StringRefEPvRS2_")
  //</editor-fold>
  public StringRef input(StringRef Scalar, Object/*void P*/ $Prm1, final Hex64 /*&*/ Val) {
    ullong$ref Num = create_ullong$ref(0);
    if (getAsUnsignedInteger(new StringRef(Scalar), 0, Num)) {
      return new StringRef(/*KEEP_STR*/"invalid hex64 number");
    }
    Val.$assign(create_ulong$ref(Num.$deref()));
    return new StringRef();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::ScalarTraits<Hex64>::mustQuote">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", line = 1235,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/YAMLTraits.h", old_line = 1205,
   FQN="llvm::yaml::ScalarTraits<Hex64>::mustQuote", NM="_ZN4llvm4yaml12ScalarTraitsINS0_5Hex64EE9mustQuoteENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLTraits.cpp -nm=_ZN4llvm4yaml12ScalarTraitsINS0_5Hex64EE9mustQuoteENS_9StringRefE")
  //</editor-fold>
  public boolean mustQuote(StringRef $Prm0) {
    return false;
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
