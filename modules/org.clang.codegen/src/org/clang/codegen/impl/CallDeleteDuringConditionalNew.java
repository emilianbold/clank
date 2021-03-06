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

package org.clang.codegen.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.codegen.impl.CGExprCXXStatics.*;


/// A cleanup to call the given 'operator delete' function upon
/// abnormal exit from a new expression when the new expression is
/// conditional.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallDeleteDuringConditionalNew">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1218,
 FQN="(anonymous namespace)::CallDeleteDuringConditionalNew", NM="_ZN12_GLOBAL__N_130CallDeleteDuringConditionalNewE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN12_GLOBAL__N_130CallDeleteDuringConditionalNewE")
//</editor-fold>
public final class CallDeleteDuringConditionalNew extends /*public*/ EHScopeStack.Cleanup {
  private /*size_t*/int NumPlacementArgs;
  private /*const*/ FunctionDecl /*P*/ OperatorDelete;
  private DominatingValueRValue.saved_type<RValue> Ptr;
  private DominatingValueRValue.saved_type<RValue> AllocSize;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallDeleteDuringConditionalNew::getPlacementArgs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1224,
   FQN="(anonymous namespace)::CallDeleteDuringConditionalNew::getPlacementArgs", NM="_ZN12_GLOBAL__N_130CallDeleteDuringConditionalNew16getPlacementArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN12_GLOBAL__N_130CallDeleteDuringConditionalNew16getPlacementArgsEv")
  //</editor-fold>
  private type$ptr<DominatingValueRValue.saved_type<RValue> /*P*/> getPlacementArgs() {
    return $this_plus_1;//((DominatingValueRValue.saved_type<RValue> /*P*/ )reinterpret_cast(DominatingValueRValue.saved_type.class, this + 1));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallDeleteDuringConditionalNew::getExtraSize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1229,
   FQN="(anonymous namespace)::CallDeleteDuringConditionalNew::getExtraSize", NM="_ZN12_GLOBAL__N_130CallDeleteDuringConditionalNew12getExtraSizeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN12_GLOBAL__N_130CallDeleteDuringConditionalNew12getExtraSizeEj")
  //</editor-fold>
  public static /*size_t*/int getExtraSize(/*size_t*/int NumPlacementArgs) {
    return NumPlacementArgs * 1/*JAVA*/;//$sizeof_Saved_type$RValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallDeleteDuringConditionalNew::CallDeleteDuringConditionalNew">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1233,
   FQN="(anonymous namespace)::CallDeleteDuringConditionalNew::CallDeleteDuringConditionalNew", NM="_ZN12_GLOBAL__N_130CallDeleteDuringConditionalNewC1EjPKN5clang12FunctionDeclENS1_7CodeGen15DominatingValueINS5_6RValueEE10saved_typeES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN12_GLOBAL__N_130CallDeleteDuringConditionalNewC1EjPKN5clang12FunctionDeclENS1_7CodeGen15DominatingValueINS5_6RValueEE10saved_typeES9_")
  //</editor-fold>
  public CallDeleteDuringConditionalNew(/*size_t*/int NumPlacementArgs, 
      /*const*/ FunctionDecl /*P*/ OperatorDelete, 
      DominatingValueRValue.saved_type<RValue> Ptr, 
      DominatingValueRValue.saved_type<RValue> AllocSize) {
    // : EHScopeStack::Cleanup(), NumPlacementArgs(NumPlacementArgs), OperatorDelete(OperatorDelete), Ptr(Ptr), AllocSize(AllocSize) 
    //START JInit
    super();
    this.NumPlacementArgs = NumPlacementArgs;
    this.OperatorDelete = OperatorDelete;
    this.Ptr = new DominatingValueRValue.saved_type<RValue>(Ptr);
    this.AllocSize = new DominatingValueRValue.saved_type<RValue>(AllocSize);
    this.$this_plus_1 = create_type$ptr(new DominatingValueRValue.saved_type[NumPlacementArgs]);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallDeleteDuringConditionalNew::setPlacementArg">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1240,
   FQN="(anonymous namespace)::CallDeleteDuringConditionalNew::setPlacementArg", NM="_ZN12_GLOBAL__N_130CallDeleteDuringConditionalNew15setPlacementArgEjN5clang7CodeGen15DominatingValueINS2_6RValueEE10saved_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN12_GLOBAL__N_130CallDeleteDuringConditionalNew15setPlacementArgEjN5clang7CodeGen15DominatingValueINS2_6RValueEE10saved_typeE")
  //</editor-fold>
  public void setPlacementArg(/*uint*/int I, DominatingValueRValue.saved_type<RValue> Arg) {
    assert ($less_uint(I, NumPlacementArgs)) : "index out of range";
    getPlacementArgs().$set(I, Arg);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallDeleteDuringConditionalNew::Emit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp", line = 1245,
   FQN="(anonymous namespace)::CallDeleteDuringConditionalNew::Emit", NM="_ZN12_GLOBAL__N_130CallDeleteDuringConditionalNew4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprCXX.cpp -nm=_ZN12_GLOBAL__N_130CallDeleteDuringConditionalNew4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE")
  //</editor-fold>
  @Override public void Emit(final CodeGenFunction /*&*/ CGF, EHScopeStack.Cleanup.Flags flags)/* override*/ {
    CallArgList DeleteArgs = null;
    try {
      /*const*/ FunctionProtoType /*P*/ FPT = OperatorDelete.getType().$arrow().getAs(FunctionProtoType.class);
      assert (FPT.getNumParams() == NumPlacementArgs + 1 || (FPT.getNumParams() == 2 && NumPlacementArgs == 0));
      
      DeleteArgs/*J*/= new CallArgList();
      
      // The first argument is always a void*.
      type$ptr<QualType> AI = $tryClone(FPT.param_type_begin());
      DeleteArgs.add(Ptr.restore(CGF), new QualType(AI.$postInc().$star()));
      
      // A member 'operator delete' can take an extra 'size_t' argument.
      if (FPT.getNumParams() == NumPlacementArgs + 2) {
        RValue RV = AllocSize.restore(CGF);
        DeleteArgs.add(new RValue(RV), new QualType(AI.$postInc().$star()));
      }
      
      // Pass the rest of the arguments, which must match exactly.
      for (/*uint*/int I = 0; I != NumPlacementArgs; ++I) {
        RValue RV = getPlacementArgs().$at(I).restore(CGF);
        DeleteArgs.add(new RValue(RV), new QualType(AI.$postInc().$star()));
      }
      
      // Call 'operator delete'.
      EmitNewDeleteCall(CGF, OperatorDelete, FPT, DeleteArgs);
    } finally {
      if (DeleteArgs != null) { DeleteArgs.$destroy(); }
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final type$ptr<DominatingValueRValue.saved_type<RValue> /*P*/> $this_plus_1;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "NumPlacementArgs=" + NumPlacementArgs // NOI18N
              + ", OperatorDelete=" + "[FunctionDecl]" // NOI18N
              + ", Ptr=" + Ptr // NOI18N
              + ", AllocSize=" + AllocSize // NOI18N
              + super.toString(); // NOI18N
  }
}
