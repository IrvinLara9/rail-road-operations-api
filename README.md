## Micronaut 3.2.7 Documentation

- [User Guide](https://docs.micronaut.io/3.2.7/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.2.7/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.2.7/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)


## Sort function

```kotlin
data class Cart(val name: String, val destination: Int, val provider: Int)

fun main(args: Array<String>) {
    val train = arrayOf(
        Cart("C1", 1, 2),
        Cart("c2", 2, 2),
        Cart("c3", 1, 1),
        Cart("c4", 3, 3),
        Cart("c5", 3, 2),
        Cart("c6", 1, 3),

        )

    println("Original array : ")
    train.forEach { println(it) }

    val sortedTrain = train.sortedWith(compareBy(Cart::destination, Cart::provider))

    println("Final array : ")
    sortedTrain.forEach { println(it) }


}
```
