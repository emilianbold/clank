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

package org.clang.driver;

import org.clank.support.*;
import org.clang.driver.*;
;

//<editor-fold defaultstate="collapsed" desc="clang::driver::VerifyPCHJobAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 459,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", old_line = 306,
 FQN="clang::driver::VerifyPCHJobAction", NM="_ZN5clang6driver18VerifyPCHJobActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver18VerifyPCHJobActionE")
//</editor-fold>
public class VerifyPCHJobAction extends /*public*/ VerifyJobAction implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::driver::VerifyPCHJobAction::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 341,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", old_line = 171,
   FQN="clang::driver::VerifyPCHJobAction::anchor", NM="_ZN5clang6driver18VerifyPCHJobAction6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver18VerifyPCHJobAction6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::VerifyPCHJobAction::VerifyPCHJobAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 343,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", old_line = 173,
   FQN="clang::driver::VerifyPCHJobAction::VerifyPCHJobAction", NM="_ZN5clang6driver18VerifyPCHJobActionC1EPNS0_6ActionENS0_5types2IDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver18VerifyPCHJobActionC1EPNS0_6ActionENS0_5types2IDE")
  //</editor-fold>
  public VerifyPCHJobAction(Action /*P*/ Input, types.ID Type) {
    /* : VerifyJobAction(VerifyPCHJobClass, Input, Type)*/ 
    //START JInit
    super(ActionClass.VerifyPCHJobClass, Input, Type);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::VerifyPCHJobAction::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 463,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", old_line = 310,
   FQN="clang::driver::VerifyPCHJobAction::classof", NM="_ZN5clang6driver18VerifyPCHJobAction7classofEPKNS0_6ActionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver18VerifyPCHJobAction7classofEPKNS0_6ActionE")
  //</editor-fold>
  public static boolean classof(/*const*/Action/*P*/ A) {
    return A.getKind() == ActionClass.VerifyPCHJobClass;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::VerifyPCHJobAction::~VerifyPCHJobAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 459,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", old_line = 306,
   FQN="clang::driver::VerifyPCHJobAction::~VerifyPCHJobAction", NM="_ZN5clang6driver18VerifyPCHJobActionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver18VerifyPCHJobActionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
