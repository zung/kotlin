//For testing error messages text see HtmlTabledDescriptorRendererTest.testFunctionPlaceholder
package a

class A<T, R>
fun <T, R> foo(a: A<T, R>) = a
fun <T, R> bar(f: (T) -> R) = f

fun test() {
    <!TYPE_INFERENCE_TYPE_CONSTRUCTOR_MISMATCH!>foo<!> <!TYPE_MISMATCH!>{ <!UNRESOLVED_REFERENCE!>it<!> }<!>
    <!TYPE_INFERENCE_TYPE_CONSTRUCTOR_MISMATCH!>foo<!> <!TYPE_MISMATCH!>{ <!CANNOT_INFER_PARAMETER_TYPE!>x<!> -> <!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>x<!>}<!>
    <!TYPE_INFERENCE_TYPE_CONSTRUCTOR_MISMATCH!>foo<!> <!TYPE_MISMATCH!>{ (x: Int) -> x}<!>

    bar { <!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>it<!> <!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>+<!> 1 }
    bar { <!CANNOT_INFER_PARAMETER_TYPE!>x<!> -> <!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>x<!> <!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>+<!> 1}
    bar { (x: Int) -> x + 1}
}
