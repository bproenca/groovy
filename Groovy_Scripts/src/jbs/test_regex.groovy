package jbs

pattern = ~/\|[A-Za-z]+\|I[AS]\|/

valor = "|ItemNf|IA|"
if (valor =~ pattern) {
	println "match"
} else {
	println "no match"
}

valor = "|ItemNf"
if (valor =~ pattern) {
	println "match"
} else {
	println "no match"
}

valor = "ItemNf"
if (valor =~ pattern) {
	println "match"
} else {
	println "no match"
}

