# BCrypt CLI

Usage: `bcrypt-cli [password] [rounds]`

* `password` defaults to `-`
* `rounds` defaults to `12`.

If `password` is `-`, read the password from stdin.

## Examples

```
bcrypt-cli
```

Reads the password from stdin, uses 12 rounds.

```
bcrypt-cli foobar
```

Uses `foobar` as the password with 12 rounds.

```
bcrypt-cli foobar 14
```

Uses `foobar` as the password with 14 rounds.

```
bcrypt-cli - 14
```

Reads the password from stdin, uses 14 rounds.

## License

[GPLv3](https://www.gnu.org/licenses/gpl-3.0.en.html)