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

package org.clang.rewrite.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.clang.rewrite.frontend.*;
import org.llvm.support.sys.path;


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FixItActionSuffixInserter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp", line = 60,
 FQN="(anonymous namespace)::FixItActionSuffixInserter", NM="_ZN12_GLOBAL__N_125FixItActionSuffixInserterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp -nm=_ZN12_GLOBAL__N_125FixItActionSuffixInserterE")
//</editor-fold>
public class FixItActionSuffixInserter extends /*public*/ FixItOptions implements Destructors.ClassWithDestructor {
  private std.string NewSuffix;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FixItActionSuffixInserter::FixItActionSuffixInserter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp", line = 64,
   FQN="(anonymous namespace)::FixItActionSuffixInserter::FixItActionSuffixInserter", NM="_ZN12_GLOBAL__N_125FixItActionSuffixInserterC1ESsb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp -nm=_ZN12_GLOBAL__N_125FixItActionSuffixInserterC1ESsb")
  //</editor-fold>
  public FixItActionSuffixInserter(std.string NewSuffix, boolean FixWhatYouCan) {
    // : FixItOptions(), NewSuffix(std::move(NewSuffix)) 
    //START JInit
    super();
    this.NewSuffix = new std.string(JD$Move.INSTANCE, std.move(NewSuffix));
    //END JInit
    this.FixWhatYouCan = FixWhatYouCan;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FixItActionSuffixInserter::RewriteFilename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp", line = 69,
   FQN="(anonymous namespace)::FixItActionSuffixInserter::RewriteFilename", NM="_ZN12_GLOBAL__N_125FixItActionSuffixInserter15RewriteFilenameERKSsRi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp -nm=_ZN12_GLOBAL__N_125FixItActionSuffixInserter15RewriteFilenameERKSsRi")
  //</editor-fold>
  @Override public std.string RewriteFilename(/*const*/std.string/*&*/ Filename, int$ref/*int &*/ fd)/* override*/ {
    fd.$set(-1);
    SmallString/*128*/ Path/*J*/= new SmallString/*128*/(new StringRef(Filename), 128);
    path.replace_extension(Path, 
        $add_Twine$C(new Twine(NewSuffix), new Twine(path.extension(Path.$StringRef()))));
    return Path.str().$string();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FixItActionSuffixInserter::~FixItActionSuffixInserter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp", line = 60,
   FQN="(anonymous namespace)::FixItActionSuffixInserter::~FixItActionSuffixInserter", NM="_ZN12_GLOBAL__N_125FixItActionSuffixInserterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp -nm=_ZN12_GLOBAL__N_125FixItActionSuffixInserterD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    NewSuffix.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "NewSuffix=" + NewSuffix // NOI18N
              + super.toString(); // NOI18N
  }
}
