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

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::LockReturnedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2971,
 FQN="clang::LockReturnedAttr", NM="_ZN5clang16LockReturnedAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16LockReturnedAttrE")
//</editor-fold>
public class LockReturnedAttr extends /*public*/ InheritableAttr implements org.clang.ast.java.ArgAttrBase {
  private Expr /*P*/ arg;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LockReturnedAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2975,
   FQN="clang::LockReturnedAttr::CreateImplicit", NM="_ZN5clang16LockReturnedAttr14CreateImplicitERNS_10ASTContextEPNS_4ExprENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16LockReturnedAttr14CreateImplicitERNS_10ASTContextEPNS_4ExprENS_11SourceRangeE")
  //</editor-fold>
  public static LockReturnedAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Expr /*P*/ Arg) {
    return CreateImplicit(Ctx, Arg, new SourceRange());
  }
  public static LockReturnedAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, Expr /*P*/ Arg, SourceRange Loc/*= SourceRange()*/) {
    LockReturnedAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new LockReturnedAttr(new SourceRange(Loc), Ctx, Arg, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LockReturnedAttr::LockReturnedAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2981,
   FQN="clang::LockReturnedAttr::LockReturnedAttr", NM="_ZN5clang16LockReturnedAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_4ExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16LockReturnedAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_4ExprEj")
  //</editor-fold>
  public LockReturnedAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      Expr /*P*/ Arg, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::LockReturned, R, SI, true, false), arg(Arg) 
    //START JInit
    super(attr.Kind.LockReturned, new SourceRange(R), SI, true, false);
    this.arg = Arg;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LockReturnedAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 2826,
   FQN="clang::LockReturnedAttr::clone", NM="_ZNK5clang16LockReturnedAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16LockReturnedAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public LockReturnedAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    LockReturnedAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new LockReturnedAttr(new SourceRange(getLocation()), C, arg, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LockReturnedAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 2834,
   FQN="clang::LockReturnedAttr::printPretty", NM="_ZNK5clang16LockReturnedAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16LockReturnedAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((lock_returned(").$out(getArg()).$out(/*KEEP_STR*/")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LockReturnedAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 2846,
   FQN="clang::LockReturnedAttr::getSpelling", NM="_ZNK5clang16LockReturnedAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16LockReturnedAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("lock_returned");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LockReturnedAttr::getArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2994,
   FQN="clang::LockReturnedAttr::getArg", NM="_ZNK5clang16LockReturnedAttr6getArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang16LockReturnedAttr6getArgEv")
  //</editor-fold>
  public Expr /*P*/ getArg() /*const*/ {
    return arg;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LockReturnedAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 3000,
   FQN="clang::LockReturnedAttr::classof", NM="_ZN5clang16LockReturnedAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang16LockReturnedAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.LockReturned;
  }

  
  @Override public String toString() {
    return "" + "arg=" + arg // NOI18N
              + super.toString(); // NOI18N
  }
}
