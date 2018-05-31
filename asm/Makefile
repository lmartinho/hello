all:
	nasm -f macho32 -O0 hello_world_32.asm
	ld hello_world_32.o -o hello_world_32
	nasm -f macho64 -O0 hello_world_64.asm
	ld hello_world_64.o -o hello_world_64

clean:
	rm hello_world_32.o hello_world_32
	rm hello_world_64.o hello_world_64