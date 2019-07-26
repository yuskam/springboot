reference :
https://github.com/eugenp/tutorials/tree/master/persistence-modules/hibernate-mapping

GIT :

- Working Directory : contains any local modification. 
- Staging Area 	    : consists of a changeset ready to be transferred to Git repository.
- Git repository    : location in which we save permanently our work and share them with other members of team.



Working Directory <----> Staging Area :

* Any local modification can be transferred to the staging area by applying : git add <file_path>
* A staged file can be "unstaged" by applying : git reset HEAD <file_name>


Staging Area  <--------> Git repository

* Once a file/ set of files is/are staged (belongs to the Stage Area), can be saved into the git repositry. All we need is to execute : git commit -m <comment> 
* To undo a commit we can use : git reset --soft HEAD~n, n : number of commits to jump back
So the HEAD will goes back n steps ..

This option allows us to go back on the commits tree but we preserve local modifications.

If we want to not preserve modifications of the reverted commits we can use : git reset --hard HEAD~n


