pattern = ~"[\n]*3579[0-4]"
text = '|LancamentoContabil|IS|767502.704425#35791|35791|ECD|SYNCHRO_256|PLANO CTAS AZUL COD01.001.9000.52104016.B.00.00000.00000|D|767502.704425|01012014|36008519.21|PROVISAO RESULTADO OPERACAO SWAP AERONAVES||9000|704425.13|N|||'

if (text =~ pattern)
	println "match"
else 
	println "no match"