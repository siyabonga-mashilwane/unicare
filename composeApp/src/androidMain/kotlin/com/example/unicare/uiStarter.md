reference: https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-layout.html#column-row-and-box

# Building UI

component → it is known as a reusable building block. It is like a Lego brick that can be used to build different parts of an app.

### Composable functions

- These are functions that take in data and spit out UI. This is used if the contents of the components will very drastically between each state a user can interact with the system.
    - e.g button can take different types of texts and varying sizes.
      Cards, Text Fields etc.

A good example in Kotlin Multiplatform is this:

```kotlin
@Composable
fun Greeting(name: String) {
    Text(text = "Hello, $name!")
}
```

The Greeting composable function, writes a new text field.

explaining the `@Composable` usage:

- the @[something], in kotlin is known as an annotation. These annotations basically mark your code and make it easier for the compiler to know which system it must use to compile the code you have provided. and in this case it marks your code to be part of a **Compose UI System,** and it tells the Compose Runtime that this function can participate in Composition and Recomposition.
- In short please mark your UI components with the `@Composable`  marker. Only mark it otherwise if there is a good reason, which most likely you have to explain during code reviews.

**Other annotations**

`@Serializable` → Enables Kotlinx Serialisation

`@Inject` → used in dependency injection (e.g. Dagger)

`@JvmStatic` → Makes a method static in terms of JAVA

`@Test` → Marks a function as a unit test

### Column, Row, and Box

Boxes, columns, and rows have long been foundational concepts in UI design, used to monitor and control the placement of elements and ensure the accuracy and consistency of layout across different screen sizes and devices.

usages:

**Column:** Used to place items vertically on the screen.

**Row:** used to place items horizontally on the screen

**Box:** Used to stack elements on top of each other.

To build responsive elements/items, there are a few functions that have build on top of the above  concepts. these are:

**FlowRow{}**

e.g

```kotlin
@Composable
fun ResponsiveLayout() {
    FlowRow {
        Text(text = "Item 1")
        Text(text = "Item 2")
        Text(text = "Item 3")
    }
}

```

**FlowColumn{}**

e.g

```kotlin
@Composable
fun ResponsiveLayout() {
    FlowColumn {
        Text(text = "Item 1")
        Text(text = "Item 2")
        Text(text = "Item 3")
    }
}

```

Read up on how to use them for most of the use cases it is experimentation.

### Modifiers

modifiers are a way for you to decotrate and add more complexity/functionality to the composable app. Up until now we have learned about the basic composable function. But now we will expand on it to add more functionality.

Note: All composable functions have the modifier parameter automatically.

**example of modifier: This modifier add padding of 16.dp**

```kotlin
@Composable
fun ModifierExample() {
    Text(
        text = "Hello with padding",
        modifier = Modifier.padding(16.dp)
    )
}
```

modifiers can also be chained to a composable object/function:

e.g

```kotlin
@Composable
private fun Greeting(name: String) {
    Column(
        // Chained `Modifier` functions:
        modifier = Modifier.padding(24.dp).fillMaxWidth()
    ) {
        Text(text = "Hello,")
        Text(text = name)
    }
}
```

→`Modifier.padding(24.dp)` adds padding around the column

→ `Modifier.fillMaxWidth()` makes the column expand to fill the available width

Research more about Modifiers for your specific Use case:

https://developer.android.com/develop/ui/compose/modifiers

### Compose Library Package

The android Compose library has alot of pre-made UI you can use.

the most common libraries are:

- [adroidx.compose.UI](https://developer.android.com/reference/kotlin/androidx/compose/ui/package-summary)  →
  contains the **fundamental UI building blocks** for layout, drawing, input handling, and platform integration — forming the core infrastructure for rendering and interacting with composable elements
- [androidx.compose.runtime](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary) → contains the **core runtime system** that enables **composition, recomposition, and state management** for building reactive UIs in a declarative way. This is necessary when building your own UI from scratch
- [androidx.composable.material3](https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary) → It is a library that contains material3 design component, basically a collection of pre-made UI instead of creating your own.
- [androidx.compose.foundation](https://developer.android.com/jetpack/androidx/releases/compose-foundation#kts) → **high-level building blocks** for Jetpack Compose UIs, including layout containers, gesture handling, scrolling, selection, and lazy lists — forming the base layer for building interactive and structured user interfaces.

Different things exist in these sub libraries of compose. It is advisable to make sure that you read up on these API references and know how they work.