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
package org.llvm.object;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.Error;
import org.llvm.object.*;;


//<editor-fold defaultstate="collapsed" desc="static type ObjectGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.object.ObjectGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=Tpl__ZN4llvm6objectlsERT_RKNS0_11DataRefImplE;_ZN4llvm6object15make_error_codeENS0_12object_errorE;_ZN4llvm6objecteqERKNS0_11DataRefImplES3_;_ZN4llvm6objectltERKNS0_11DataRefImplES3_;_ZN4llvm6objectneERKNS0_11DataRefImplES3_; -static-type=ObjectGlobals -package=org.llvm.object")
//</editor-fold>
public final class ObjectGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::object::make_error_code">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/Error.h", line = 39,
 FQN="llvm::object::make_error_code", NM="_ZN4llvm6object15make_error_codeENS0_12object_errorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6object15make_error_codeENS0_12object_errorE")
//</editor-fold>
public static /*inline*/ std.error_code make_error_code(object_error e) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <typename OStream> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::object::operator<<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 35,
 FQN="llvm::object::operator<<", NM="Tpl__ZN4llvm6objectlsERT_RKNS0_11DataRefImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=Tpl__ZN4llvm6objectlsERT_RKNS0_11DataRefImplE")
//</editor-fold>
public static </*typename*/ OStream> OStream /*&*/ $out_T$R_DataRefImpl$C(final OStream /*&*/ OS, final /*const*/ DataRefImpl /*&*/ D) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::object::operator==">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 40,
 FQN="llvm::object::operator==", NM="_ZN4llvm6objecteqERKNS0_11DataRefImplES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6objecteqERKNS0_11DataRefImplES3_")
//</editor-fold>
public static /*inline*/ boolean $eq_DataRefImpl$C(final /*const*/ DataRefImpl /*&*/ a, final /*const*/ DataRefImpl /*&*/ b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::object::operator!=">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 46,
 FQN="llvm::object::operator!=", NM="_ZN4llvm6objectneERKNS0_11DataRefImplES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6objectneERKNS0_11DataRefImplES3_")
//</editor-fold>
public static /*inline*/ boolean $noteq_DataRefImpl$C(final /*const*/ DataRefImpl /*&*/ a, final /*const*/ DataRefImpl /*&*/ b) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::object::operator<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Object/SymbolicFile.h", line = 50,
 FQN="llvm::object::operator<", NM="_ZN4llvm6objectltERKNS0_11DataRefImplES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6objectltERKNS0_11DataRefImplES3_")
//</editor-fold>
public static /*inline*/ boolean $less_DataRefImpl$C(final /*const*/ DataRefImpl /*&*/ a, final /*const*/ DataRefImpl /*&*/ b) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class ObjectGlobals
