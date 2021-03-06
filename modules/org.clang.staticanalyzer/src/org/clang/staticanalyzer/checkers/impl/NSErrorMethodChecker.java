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

package org.clang.staticanalyzer.checkers.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.checkers.impl.NSErrorCheckerStatics.*;
import org.clang.staticanalyzer.java.CheckBase;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NSErrorMethodChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp", line = 40,
 FQN="(anonymous namespace)::NSErrorMethodChecker", NM="_ZN12_GLOBAL__N_120NSErrorMethodCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp -nm=_ZN12_GLOBAL__N_120NSErrorMethodCheckerE")
//</editor-fold>
public class NSErrorMethodChecker extends /*public*/ Checker/*T<ASTDecl<ObjCMethodDecl> > */
        implements org.clang.staticanalyzer.java.ASTDeclChecker<ObjCMethodDecl>, Destructors.ClassWithDestructor {
  private /*mutable */IdentifierInfo /*P*/ II;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NSErrorMethodChecker::NSErrorMethodChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp", line = 45,
   FQN="(anonymous namespace)::NSErrorMethodChecker::NSErrorMethodChecker", NM="_ZN12_GLOBAL__N_120NSErrorMethodCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp -nm=_ZN12_GLOBAL__N_120NSErrorMethodCheckerC1Ev")
  //</editor-fold>
  public NSErrorMethodChecker() {
    // : Checker<ASTDecl<ObjCMethodDecl> >(), II(null) 
    //START JInit
    super();
    this.II = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NSErrorMethodChecker::checkASTDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp", line = 52,
   FQN="(anonymous namespace)::NSErrorMethodChecker::checkASTDecl", NM="_ZNK12_GLOBAL__N_120NSErrorMethodChecker12checkASTDeclEPKN5clang14ObjCMethodDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp -nm=_ZNK12_GLOBAL__N_120NSErrorMethodChecker12checkASTDeclEPKN5clang14ObjCMethodDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterE")
  //</editor-fold>
  public void checkASTDecl(/*const*/ ObjCMethodDecl /*P*/ D, 
              final AnalysisManager /*&*/ mgr, 
              final BugReporter /*&*/ BR) /*const*/ {
    if (!D.isThisDeclarationADefinition()) {
      return;
    }
    if (!D.getReturnType().$arrow().isVoidType()) {
      return;
    }
    if (!(II != null)) {
      II = $AddrOf(D.getASTContext().Idents.get(new StringRef(/*KEEP_STR*/"NSError")));
    }
    
    boolean hasNSError = false;
    for (/*const*/ ParmVarDecl /*P*/ I : D.parameters()) {
      if (IsNSError(I.getType(), II)) {
        hasNSError = true;
        break;
      }
    }
    if (hasNSError) {
      /*const*/char$ptr/*char P*/ err = $("Method accepting NSError** should have a non-void return value to indicate whether or not an error occurred");
      PathDiagnosticLocation L = PathDiagnosticLocation.create(D, BR.getSourceManager());
      BR.EmitBasicReport(D, this, new StringRef(/*KEEP_STR*/"Bad return type when passing NSError**"), 
          new StringRef(/*KEEP_STR*/"Coding conventions (Apple)"), new StringRef(err), new PathDiagnosticLocation(L));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NSErrorMethodChecker::~NSErrorMethodChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp", line = 40,
   FQN="(anonymous namespace)::NSErrorMethodChecker::~NSErrorMethodChecker", NM="_ZN12_GLOBAL__N_120NSErrorMethodCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp -nm=_ZN12_GLOBAL__N_120NSErrorMethodCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new ASTDecl<ObjCMethodDecl>(ObjCMethodDecl.class)
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  @Override public String toString() {
    return "" + "II=" + II // NOI18N
              + super.toString(); // NOI18N
  }
}
