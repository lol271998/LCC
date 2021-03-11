#include <sys/types.h>
#include <sys/stat.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char* argv[]) {
	if (argc != 3 ) {
		(void)fprintf(stderr, "usage: %s perms file\n", argv[0]);
		return EXIT_FAILURE;
	}
	/*
	 *
	 * perm - permissions
	 * uperms - user permissions 
	 * operms - other permissions
	 * gperms - group permissions
	 * newperms - new permissions
	 *  
	*/

	int perms = atoi(argv[1]);
	int operms = perms % 10;
	perms = perms / 10;
	
	int gperms = perms % 10;
	perms = perms / 10;
	
	int uperms = perms;
	mode_t newperms = (mode_t)0;

	//printf("uperms: %d | gperms: %d | operms: %d | newperms: %d\n",uperms,gperms,operms,newperms);

	/*
	* S_IRWXU
	* 	read, write, execute/search by user
	* S_IRUSR
	*	read permission, user
	* S_IWUSR
	*	write permission, user
	* S_IXUSR
	*	execute/search permission, user
	* S_IRWXG
	*	read, write, execute/search by group
	* S_IRGRP
	*	read permission, group
	* S_IWGRP
	*	write permission, group
	* S_IXGRP
	*	execute/search permission, group
	* S_IRWXO
	*	read, write, execute/search by others
	* S_IROTH
	*	read permission, others
	* S_IWOTH
	*	write permission, others
	* S_IXOTH
	*	execute/search permission, others
	* S_ISUID
	*	set-user-ID on execution
	* S_ISGID
	*	set-group-ID on execution
	* S_ISVTX
	*	on directories, restricted deletion flag
	*/
	// leitura (r) - escrita (w) - execução (x): 7 = (111)
	// Permissões do utilizador

	switch (uperms) {
		case 0: 
			break;
		case 1: newperms |= S_IXUSR; break; //001
		case 2: newperms |=	S_IWUSR; break; //010
		case 3: newperms |= S_IWUSR | S_IXUSR; break; //011
		case 4: newperms |= S_IRUSR; break; //100
		case 5: newperms |= S_IRUSR | S_IXUSR; break; //101
		case 6: newperms |= S_IRUSR | S_IWUSR; break; //011
		case 7: newperms |= S_IRUSR | S_IWUSR | S_IXUSR; break; //111 (ou S_IRWXU)
		default:
			(void)fprintf(stderr, "%s: illegal permission value\n", argv[0]);
		return EXIT_FAILURE;
	}

	//Permissões de grupo
	switch (gperms) {
		case 0: break;
		case 1: newperms |= S_IXGRP; break; 
		case 2: newperms |= S_IWGRP; break;
		case 3: newperms |= S_IWGRP | S_IXGRP; break;
		case 4: newperms |= S_IRGRP; break;
		case 5: newperms |= S_IWGRP | S_IXGRP; break;
		case 6: newperms |= S_IRGRP | S_IWGRP; break;
		case 7: newperms |= S_IRGRP | S_IWGRP | S_IXGRP; break;
		default:
			(void)fprintf(stderr, "%s: illegal permission value\n", argv[0]);
		return EXIT_FAILURE;
	}
	
	//Permissões de others
	switch (operms) {
		case 0: break;
		case 1: newperms |= S_IXOTH; break;
		case 2: newperms |= S_IWOTH; break;
		case 3: newperms |= S_IWOTH | S_IXOTH; break;
		case 4: newperms |= S_IROTH; break;
		case 5: newperms |= S_IROTH | S_IXOTH; break;
		case 6: newperms |= S_IROTH | S_IWOTH; break;
		case 7: newperms |= S_IROTH | S_IWOTH | S_IXOTH; break;
		default:
		(void)fprintf(stderr, "%s: illegal permission value\n", argv[0]);
		return EXIT_FAILURE;
	}

	if (chmod(argv[2], newperms) == -1) {
		(void)fprintf(stderr, "%s: cannot chmod %s\n", argv[0], argv[2]);
		return EXIT_FAILURE;
	}
	return EXIT_SUCCESS;
}