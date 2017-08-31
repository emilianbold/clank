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

package org.llvm.analysis;

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
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.DominanceFrontierGlobals.ForwardDominanceFrontierBase;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import org.llvm.analysis.bfi_detail.*;
import org.llvm.analysis.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontier">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 137,
 FQN="llvm::DominanceFrontier", NM="_ZN4llvm17DominanceFrontierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm17DominanceFrontierE")
//</editor-fold>
public class DominanceFrontier extends /*public*/ ForwardDominanceFrontierBase<BasicBlock> implements Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: typedef DominatorTreeBase<BasicBlock> DomTreeT
//  public final class DomTreeT extends DominatorTreeBase$BasicBlock{ };
  // JAVA: typedef DomTreeNodeBase<BasicBlock> DomTreeNodeT
//  public final class DomTreeNodeT extends DomTreeNodeBase$BasicBlock{ };
  // JAVA: typedef DominanceFrontierBase<BasicBlock>::DomSetType DomSetType
//  public final class DomSetType extends std.set<BasicBlock /*P*/ >{ };
  // JAVA: typedef DominanceFrontierBase<BasicBlock>::iterator iterator
//  public final class iterator extends std._Rb_tree_iterator<std.pair<BasicBlock /*P*/ /*const*/, std.set<BasicBlock /*P*/ , std.less<BasicBlock /*P*/ >, default_ptr_allocator> > >{ };
  // JAVA: typedef DominanceFrontierBase<BasicBlock>::const_iterator const_iterator
//  public final class const_iterator extends std._Rb_tree_const_iterator<std.pair<BasicBlock /*P*/ /*const*/, std.set<BasicBlock /*P*/ , std.less<BasicBlock /*P*/ >, default_ptr_allocator> > >{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontier::~DominanceFrontier">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 137,
   FQN="llvm::DominanceFrontier::~DominanceFrontier", NM="_ZN4llvm17DominanceFrontierD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm17DominanceFrontierD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontier::DominanceFrontier">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 137,
   FQN="llvm::DominanceFrontier::DominanceFrontier", NM="_ZN4llvm17DominanceFrontierC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm17DominanceFrontierC1Ev")
  //</editor-fold>
  public /*inline*/ DominanceFrontier() {
    // : ForwardDominanceFrontierBase<BasicBlock>() 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontier::DominanceFrontier">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 137,
   FQN="llvm::DominanceFrontier::DominanceFrontier", NM="_ZN4llvm17DominanceFrontierC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm17DominanceFrontierC1EOS0_")
  //</editor-fold>
  public /*inline*/ DominanceFrontier(JD$Move _dparam, final DominanceFrontier /*&&*/$Prm0) {
    // : ForwardDominanceFrontierBase<BasicBlock>(static_cast<DominanceFrontier &&>()) 
    //super(JD$Move.INSTANCE, $Prm0);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}