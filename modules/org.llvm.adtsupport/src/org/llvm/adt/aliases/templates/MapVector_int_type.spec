FILE_NAME = MapVectorIntType
CLASS_SUFFIX = <ValueT>
MAP_TYPE = DenseMapIntUInt
MAP_ITER = DenseMapIteratorIntUInt
MAP_PAIR = std.pairIntUInt
VECTOR_TYPE = std.vector<std.pairIntType<ValueT>>
VECTOR_ITER = std.vector.iterator<std.pairIntType<ValueT>>
VECTOR_REVERSE_ITER = std.reverse_iterator<std.pairIntType<ValueT>>
VECTOR_PAIR = std.pairIntType<ValueT>
KEY_TYPE = int
VALUE_TYPE = ValueT
VALUE_REFERENCE_TYPE = type$ref<ValueT>
IS_DATA_POINTER_LIKE = false
DEFAULT_VALUE = (ValueT)$Clone((NativeCloneable)defaultValue)
DENSE_MAP_INFO = DenseMapInfoInt
DEFAULT_DENSE_MAP_INFO = DenseMapInfoInt.$Info()
EMPTY_DEFAULT_KEY=0
EMPTY_DEFAULT_VALUE=defaultValue
ASSERT_DEFAULT_VALUE= (defaultValue instanceof NativeCloneable) && NativeTrace.assertDefaultValue(defaultValue)